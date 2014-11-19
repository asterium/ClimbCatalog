package com.example.ClimbCatalog.Models;

/**
 * Created by asterium on 17.11.14.
 */
public class Route {
    private String title;
    private String complexity;
    private int points;
    private String arrayTitle;

    public Route(String title, String complexity, int points, String arrayTitle) {
        this.title = title;
        this.complexity = complexity;
        this.points = points;
        this.arrayTitle = arrayTitle;
    }

    public  Route(){
        this.title = "";
        this.complexity = "";
        this.points = 0;
        this.arrayTitle = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getArrayTitle() {
        return arrayTitle;
    }

    public void setArrayTitle(String arrayTitle) {
        this.arrayTitle = arrayTitle;
    }
}
