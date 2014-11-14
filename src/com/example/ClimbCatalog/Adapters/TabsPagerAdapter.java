package com.example.ClimbCatalog.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.ClimbCatalog.Fragments.RegionInfoFragment;
import com.example.ClimbCatalog.Fragments.RegionRoutesSummaryFragment;

/**
 * Created by dmytro_zaitsev on 12.11.14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index){
            case 0: return new RegionInfoFragment();
            case 1: return new RegionRoutesSummaryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

