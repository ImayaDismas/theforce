package com.example.jaykayitare.theforce.adapter;

import com.google.gson.annotations.Expose;

/**
 * Created by imaya on 5/25/16.
 */
public class StoryObjects {
    @Expose
    private String title;
    @Expose
    private String user_id;
    @Expose
    private String intro;
    @Expose
    private String media_url;
    @Expose
    private String timestamp;
    @Expose
    private String location;


    public String getTitle() {
        return this.title;
    }
    public String getUser_id() {
        return this.user_id;
    }
    public String getIntro() {
        return this.intro;
    }
    public String getMedia(){
        return this.media_url;
    }
    public String getTimestamp() {
        return this.timestamp;
    }
    public String getLocation() {
        return this.location;
    }
}
