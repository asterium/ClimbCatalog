package com.example.ClimbCatalog.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ClimbCatalog.R;


/**
 * Created by dmytro_zaitsev on 12.11.14.
 */
public class RegionInfoFragment extends android.support.v4.app.Fragment {

     @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View regionRoutesTab = inflater.inflate(R.layout.draft_region_menu_tab2, container, false);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.draft_region_menu, container, false);
    }
}
