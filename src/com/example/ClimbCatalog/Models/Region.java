package com.example.ClimbCatalog.Models;

import java.util.List;

/**
 * Created by asterium on 17.11.14.
 */
public class Region {
    String title;
    List<Route> routes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
