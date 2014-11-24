package com.example.ClimbCatalog.DAO;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.example.ClimbCatalog.Models.Region;
import com.example.ClimbCatalog.Models.RockArray;
import com.example.ClimbCatalog.Models.Route;
import com.example.ClimbCatalog.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by asterium on 17.11.14.
 */
public class RegionRoutesDao {
    private Context context;

    public RegionRoutesDao(Context context) {
        this.context = context;
    }

    public List<String> getArraysForRegion(Region region){
        String regionTitle = region.getTitle();
        Resources res = context.getResources();
        String[] results;
        if(regionTitle == "Denyshy") {
            results = res.getStringArray(R.array.regionArraysDenyshy);
        }
        else{
            results = new String[1];
        }
    return Arrays.asList(results);
    }

    public List<Route> getRoutesForArray(RockArray array){
        String array_title = array.getTitle();
        if(array_title == "A"){}
    }
}
