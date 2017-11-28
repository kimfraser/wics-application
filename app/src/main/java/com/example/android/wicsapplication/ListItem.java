package com.example.android.wicsapplication;

/**
 * Created by Kimbers on 11/21/17.
 */

public class ListItem {
    private String name;
    private String date;
    private String time;
    private String description;
    private String location;

    public ListItem() {}
    public ListItem(String name, String date, String time, String desc, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.description = desc;
        this.location = location;
    }

    public String getEventName() {
        return name;
    }

    public String getEventDate() {
        return date;
    }

    public String getEventTime() {
        return time;
    }

    public String getEventDescription() {
        return description;
    }

    public String getEventLocation() {
        return location;
    }

}
