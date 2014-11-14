package com.example.ClimbCatalog.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.ClimbCatalog.R;


/**
 * Created by dmytro_zaitsev on 12.11.14.
 */
public class RegionRoutesSummaryFragment extends android.support.v4.app.Fragment {
    String[] routes;
    Context context = getActivity();

    private TableRow createRouteRow(String name, String complexity, String points) {
        TableRow row = new TableRow(getActivity());
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        row.setBackgroundColor(Color.WHITE);
//

        LinearLayout titleContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams titleLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.58f);
        titleLayoutParams.setMargins(1, 1, 1, 1);
        titleContainer.setBackgroundColor(Color.BLACK);
        titleContainer.setLayoutParams(titleLayoutParams);
        TextView routeTitle = new TextView(getActivity());
        routeTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routeTitle.setText(name);
        titleContainer.addView(routeTitle);

        LinearLayout complexityContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams complexityLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.2f);
        complexityLayoutParams.setMargins(1, 1, 1, 1);
        complexityContainer.setBackgroundColor(Color.BLACK);
        complexityContainer.setLayoutParams(complexityLayoutParams);

        TextView routeComplexity = new TextView(getActivity());
        routeComplexity.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routeComplexity.setText(complexity);
        complexityContainer.addView(routeComplexity);


        LinearLayout pointsContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams pointsLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.2f);
        pointsLayoutParams.setMargins(1, 1, 1, 1);
        pointsContainer.setBackgroundColor(Color.BLACK);
        pointsContainer.setLayoutParams(complexityLayoutParams);

        TextView routePoints = new TextView(getActivity());
        routePoints.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routePoints.setText(points);

        pointsContainer.addView(routePoints);

        row.addView(titleContainer);
        row.addView(complexityContainer);
        row.addView(pointsContainer);
        return row;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        routes = getResources().getStringArray(R.array.massiv_A);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View regionRoutesTab = inflater.inflate(R.layout.region_routes_fragment, container, false);
        TableLayout dataContainer = (TableLayout) getActivity().findViewById(R.id.routesDataContainer);

        TableRow row = createRouteRow("Название маршрута", "Сложность", "Количество точек");
        dataContainer.addView(row);

//        ScrollView routeList = new ScrollView(context);
//        routeList.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.WRAP_CONTENT));
//
//        TableRow scrollViewContainer = new TableRow(context);
//        routeList.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        scrollViewContainer.addView(scrollViewContainer);
//
//        dataContainer.addView(scrollViewContainer);
////        dataContainer.addView(routeList);
//
//        TableLayout routeListData = new TableLayout(context);
//        routeListData.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

//        for (String routeName : routes) {
//            routeListData.addView(createRouteRow(routeName, "8C", Integer.toString(8)));
//        }

//        scrollViewContainer.addView(routeListData);
        // Inflate the layout for this fragment

        return regionRoutesTab;
    }
}
