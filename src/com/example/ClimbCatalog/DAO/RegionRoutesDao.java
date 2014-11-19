package com.example.ClimbCatalog.DAO;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.example.ClimbCatalog.Models.Region;
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
        if(regionTitle == "Denyshy") {
            TypedArray ta = res.obtainTypedArray(R.array.regionDenyshy);
            int n = ta.length();
            String[][] array = new String[n][];
            for (int i = 0; i < n; ++i) {
                int id = ta.getResourceId(i, 0);
                if (id > 0) {
                    array[i] = res.getStringArray(id);
                } else {
                    // something wrong with the XML
                }
            }
            System.out.println(Arrays.toString(array));
            ta.recycle(); // Important!
        }
return new ArrayList<String>();
    }


}
