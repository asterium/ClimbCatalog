package com.example.ClimbCatalog.Models;

import java.util.List;

/**
 * Created by asterium on 24.11.14.
 */
public class RockArray {
    private String title;
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

//    public void setRoutes(List<Route> routes) {
//        this.routes = routes;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
