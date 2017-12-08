package com.example.android.wicsapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Kimbers on 11/21/17.
 */

public class ListItem implements Parcelable{
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

    public ListItem(Parcel in) {
        String[] data = new String[5];
        in.readStringArray(data);
        name = data[0];
        date = data[1];
        time = data[2];
        description = data[3];
        location = data[4];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                name, date, time, description, location
        });
    }


    public static final Parcelable.Creator<ListItem>CREATOR = new Parcelable.Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel source) {
            return new ListItem(source);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

}
