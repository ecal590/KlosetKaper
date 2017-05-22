package com.example.ebonycalloway.klosetkaper.POJO;

import android.graphics.Bitmap;

/**
 * Created by ebonycalloway on 3/10/17.
 */

public class Clothing {
    String name;
    String primaryColor;
    String secondaryColor;
    String category;
    String occassion;
    String description;
    String location;
    byte[] picture;
    long date;
    double cost;
    int wears;
    int wash;
    int rating;

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    /*public Clothing(String name, String primaryColor, String secondColor, String category, String description, String occassion, String location , long date, double cost , int rating) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondColor;
        this.category = category;
        this.description = description;
        this.occassion = occassion;
        this.location = location;
        this.cost = cost;
        this.date = date;
        this.wears = 0;
        this.wash = 0;
        this.rating = rating;
    }*/
    public Clothing(String name, String primaryColor, String secondaryColor, String category, String description, String occassion, String location, long date, double cost ,int rating) {
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.category = category;
        this.description = description;
        this.occassion = occassion;
        this.location = location;
        this.cost = cost;
        this.date = date;
        this.wears = 0;
        this.wash = 0;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "com.example.ebonycalloway.klosetkaper.POJO.Clothing{" +
                "name='" + name + '\'' +
                ", primaryColor='" + primaryColor + '\'' +
                ", secondaryColor='" + secondaryColor + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", occassion='" + occassion + '\'' +
                ", date=" + date +
                ", wears=" + wears +
                ", wash=" + wash +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getWears() {
        return wears;
    }

    public void setWears(int wears) {
        this.wears = wears;
    }

    public int getWash() {
        return wash;
    }

    public void setWash(int wash) {
        this.wash = wash;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
