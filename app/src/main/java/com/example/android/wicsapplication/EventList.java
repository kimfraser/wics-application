package com.example.android.wicsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventList extends AppCompatActivity {

    DatabaseReference databaseEvents;

    ListView listViewEvents;

    List<ListItem> eventsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        databaseEvents = FirebaseDatabase.getInstance().getReference().child("events");

        listViewEvents = (ListView) findViewById(R.id.eventsList);
        eventsList = new ArrayList<>();


        /*ArrayList<ListItem> events = new ArrayList<>();
        events.add(new ListItem("Name","Date", "Time,","Desc","DC 2320"));
        ListAdapter eventsAdapter = new ListAdapter(this, events);

        ListView eventsList = (ListView) findViewById(R.id.eventsList);
        eventsList.setAdapter(eventsAdapter);*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                eventsList.clear();
                for (DataSnapshot eventSnapshot: dataSnapshot.getChildren()) {
                    ListItem event = new ListItem(eventSnapshot.child("name").getValue().toString(), eventSnapshot.child("date").getValue().toString(), eventSnapshot.child("time").getValue().toString(), eventSnapshot.child("description").getValue().toString(), eventSnapshot.child("location").getValue().toString());

                    eventsList.add(event);
                }

                ListAdapter adapter = new ListAdapter(EventList.this, eventsList);
                listViewEvents.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
