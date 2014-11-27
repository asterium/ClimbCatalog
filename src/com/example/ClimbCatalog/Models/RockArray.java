package com.example.ClimbCatalog.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asterium on 24.11.14.
 */
public class RockArray {
    private String title;
    private List<Route> routes;

    public RockArray(String title) {
        this.title = title;
        this.routes = new ArrayList<Route>();
    }

    public RockArray(String title, List<Route> routes) {
        this.title = title;
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addRoute(Route route){
        routes.add(route);
    }


}
