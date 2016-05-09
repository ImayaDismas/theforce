package com.example.jaykayitare.theforce.model;

/**
 * Created by jaykayitare on 5/9/16.
 */
public class Collaborator {
    private String username, time;

    public Collaborator(String username, String time) {
        this.username = username;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
