package com.example.ClimbCatalog.DAO;

import android.content.Context;
import android.util.Log;
import com.example.ClimbCatalog.Models.Region;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asterium on 17.11.14.
 */
public class RegionRoutesDao {
    Context context;
    private Map<String, String> regionXmlStorage = new HashMap<String, String>();
    private Map<String, Region> regions = new HashMap<String, Region>();


    public RegionRoutesDao(Context context) {
        this.context = context;
        regionXmlStorage.put("Denyshy", "denyshy_region_xml");
    }

    public Region getRegionDataByName(String name){
        Region region = null;
        if(regions.containsKey(name)){
            region = regions.get(name);
        }
        else if(regionXmlStorage.containsKey(name)){
            try {

                InputStream is = context.getResources().openRawResource(context.getResources().getIdentifier("raw/" + regionXmlStorage.get(name), "raw", context.getPackageName()));
                RegionXmlParser rxp = new RegionXmlParser();
                List<Region> new_parsed_regions= rxp.parse(is);
                for (Region r : new_parsed_regions){
                    regions.put(r.getTitle(),r);
                }
                if(regions.containsKey(name)){
                    region = regions.get(name);
                }
            }
            catch (XmlPullParserException xpe){
                Log.e("DAO", "Impossible to parse raw resource "+ regionXmlStorage.get(name));
            }
            catch (IOException e) {
                Log.e("DAO", "Error in inputstream");
                e.printStackTrace();
            }
        }
        return region;

    };










}
