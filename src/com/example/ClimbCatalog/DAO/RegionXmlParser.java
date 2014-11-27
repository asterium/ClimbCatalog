package com.example.ClimbCatalog.DAO;

import android.util.Xml;
import com.example.ClimbCatalog.Models.Region;
import com.example.ClimbCatalog.Models.RockArray;
import com.example.ClimbCatalog.Models.Route;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro_zaitsev on 26.11.14.
 */
public class RegionXmlParser {
    private static final String ns = null;

    public List<Region> parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            List<Region> regions = new ArrayList<Region>();
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            regions.add(readRegion(parser));
            return regions;
        } finally {
            in.close();
        }
    }

    private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "title");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "title");
        return title;
    }

    private String readComplexity(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "complexity");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "complexity");
        return title;
    }

    private int readPoints(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "points");
        String points = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "points");
        return Integer.valueOf(points);
    }
    // Extracts text values
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private Route readRoute(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "route");
        String title = null;
        String complexity = null;
        int points = 0;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("title")) {
                title = readTitle(parser);
            } else if (name.equals("complexity")) {
                complexity = readComplexity(parser);
            } else if (name.equals("link")) {
                points = readPoints(parser);
            } else {
                skip(parser);
            }
        }
        return new Route(title, complexity, points);
    }


    private RockArray readArray(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "array");
        String title = parser.getAttributeValue(ns, "name");
        List<Route> routes = new ArrayList<Route>();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("route")) {
                routes.add(readRoute(parser));
             } else {
                skip(parser);
            }
        }
        return new RockArray(title, routes);
    }

    private Region readRegion(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "region");
        String title = parser.getAttributeValue(ns, "name");;
        List<RockArray> routes = new ArrayList<RockArray>();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("array")) {
                routes.add(readArray(parser));
            } else {
                skip(parser);
            }
        }
        return new Region(title, routes);
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

}
