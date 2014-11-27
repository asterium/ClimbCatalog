package com.example.ClimbCatalog.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asterium on 17.11.14.
 */
public class Region {
    String title;
    List<RockArray> arrays;

    public Region(String title) {
        this.title = title;
        this.arrays = new ArrayList<RockArray>();
    }

    public Region(String title, List<RockArray> routes) {
        this.title = title;
        this.arrays = routes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RockArray> getArrays() {
        return arrays;
    }

    public void addRockArray(RockArray array){
        arrays.add(array);
    }

}
