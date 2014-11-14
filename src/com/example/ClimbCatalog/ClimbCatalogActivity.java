package com.example.ClimbCatalog;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class ClimbCatalogActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.mainmenu);
        setContentView(R.layout.draft_region_menu);
        setContentView(R.layout.draft_region_menu);
        TabHost regionTabMenu = (TabHost) findViewById(R.id.tabHost);
        regionTabMenu.setup();
        TabHost.TabSpec spec = regionTabMenu.newTabSpec("region_info");
        spec.setIndicator("Общая информация");
        spec.setContent(R.id.tab1);
        regionTabMenu.addTab(spec);
        spec = regionTabMenu.newTabSpec("region_routes");
        spec.setIndicator("Маршруты");
        spec.setContent(R.id.tab2);
        regionTabMenu.addTab(spec);



    }
}
