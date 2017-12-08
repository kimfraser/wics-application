package com.example.android.wicsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_page);
        TextView title = (TextView) findViewById(R.id.eventTitle);
        TextView date = (TextView) findViewById(R.id.date);
        TextView location = (TextView) findViewById(R.id.location);
        TextView time = (TextView) findViewById(R.id.eventTime);
        TextView description = (TextView) findViewById(R.id.descriptionHdr);



        Intent intent = getIntent();
        //Bundle eventInfo = intent.getExtras();

        ListItem event = (ListItem) intent.getParcelableExtra("EventInfo");

        title.setText(event.getEventName());
        date.setText(event.getEventDate());
        location.setText(event.getEventLocation());
        time.setText(event.getEventTime());
        description.setText(event.getEventDescription());

    }
}
