package com.example.ClimbCatalog.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.ClimbCatalog.DAO.RegionRoutesDao;
import com.example.ClimbCatalog.Helpers.Helper;
import com.example.ClimbCatalog.Models.Region;
import com.example.ClimbCatalog.Models.RockArray;
import com.example.ClimbCatalog.Models.Route;
import com.example.ClimbCatalog.R;


/**
 * Created by dmytro_zaitsev on 12.11.14.
 */
public class RegionRoutesSummaryFragment extends android.support.v4.app.Fragment {
    String[] routes;
    Context context = getActivity();

    private TableRow createRouteRow(String name, String complexity, String points) {
        int textPadding = Helper.convertDpToPixel(1, getActivity().getApplicationContext());
        TableRow row = new TableRow(getActivity());
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        row.setBackgroundColor(Color.WHITE);

        LinearLayout titleContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams titleLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0.58f);
        titleLayoutParams.setMargins(1, 1, 1, 1);
        titleContainer.setBackgroundColor(Color.BLACK);
        titleContainer.setLayoutParams(titleLayoutParams);
        titleContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView routeTitle = new TextView(getActivity());
        routeTitle.setPadding(0,textPadding,0,textPadding);
        routeTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routeTitle.setText(name);
        titleContainer.addView(routeTitle);

        LinearLayout complexityContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams complexityLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
        complexityLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        complexityLayoutParams.setMargins(1, 1, 1, 1);
        complexityContainer.setBackgroundColor(Color.BLACK);
        complexityContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        complexityContainer.setLayoutParams(complexityLayoutParams);

        TextView routeComplexity = new TextView(getActivity());
        routeComplexity.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routeComplexity.setText(complexity);
        routeComplexity.setPadding(0,textPadding,0,textPadding);
        complexityContainer.addView(routeComplexity);

        LinearLayout pointsContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams pointsLayoutParams = new TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 0.2f);
        pointsLayoutParams.setMargins(1, 1, 1, 1);
        pointsContainer.setBackgroundColor(Color.BLACK);
        pointsContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        pointsContainer.setLayoutParams(complexityLayoutParams);

        TextView routePoints = new TextView(getActivity());
        routePoints.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routePoints.setText(points);
        routePoints.setPadding(0,textPadding,0,textPadding);
        pointsContainer.addView(routePoints);

        row.addView(titleContainer);
        row.addView(complexityContainer);
        row.addView(pointsContainer);
        return row;
    }

    private TableRow createTitleRow(String name) {
        int textPadding = Helper.convertDpToPixel(1, getActivity().getApplicationContext());
        TableRow row = new TableRow(getActivity());
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        row.setBackgroundColor(Color.WHITE);

        LinearLayout titleContainer = new LinearLayout(getActivity());
        LinearLayout.LayoutParams titleLayoutParams = new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        titleLayoutParams.setMargins(1, 1, 1, 1);
        titleContainer.setBackgroundColor(Color.BLACK);
        titleContainer.setLayoutParams(titleLayoutParams);
        titleContainer.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        TextView routeTitle = new TextView(getActivity());
        routeTitle.setPadding(textPadding,textPadding,textPadding,textPadding);
        routeTitle.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        routeTitle.setText(name);
        titleContainer.addView(routeTitle);

        row.addView(titleContainer);
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
        TableLayout dataContainer = (TableLayout) regionRoutesTab.findViewById(R.id.routesDataContainer);

        dataContainer.addView(createRouteRow("Название маршрута", "Сложность", "Количество точек"));

        ScrollView routeList = new ScrollView(getActivity());
        routeList.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,ScrollView.LayoutParams.MATCH_PARENT));


        TableLayout routeListData = new TableLayout(getActivity());
        routeListData.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));


        RegionRoutesDao daoObject = new RegionRoutesDao(getActivity());
        Region r = daoObject.getRegionDataByName("Denyshy");
        for(RockArray array : r.getArrays()){
            routeListData.addView(createTitleRow("Массив" + array.getTitle()));

            for(Route route : array.getRoutes()){
                routeListData.addView(createRouteRow(route.getTitle(), route.getComplexity(), Integer.toString(route.getPoints())));
            }
        }
//        for (String routeName : routes) {
//            routeListData.addView(createRouteRow(routeName, "8C", Integer.toString(8)));
//        }

        routeList.addView(routeListData);
        dataContainer.addView(routeList);

        return regionRoutesTab;
    }
}
