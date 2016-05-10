package com.example.jaykayitare.theforce.model;

/**
 * Created by jaykayitare on 5/10/16.
 */
public class Story {
    private String title, location, timedate;
    private int bits;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public Story(String title, String location, String timedate, int bits) {
        this.title = title;
        this.location = location;
        this.timedate = timedate;
        this.bits = bits;
    }


}
