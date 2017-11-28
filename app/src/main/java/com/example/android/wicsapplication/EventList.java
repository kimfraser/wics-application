package com.example.android.wicsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        ArrayList<ListItem> events = new ArrayList<>();
        events.add(new ListItem("Name","Date", "Time,","Desc","DC 2320"));
        ListAdapter eventsAdapter = new ListAdapter(this, events);

        ListView eventsList = (ListView) findViewById(R.id.eventsList);
        eventsList.setAdapter(eventsAdapter);
    }
}
