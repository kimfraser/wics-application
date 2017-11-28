package com.example.android.wicsapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void goToEventsPage (View view){
        Intent eventsList = new Intent(this, EventList.class);
        startActivity(eventsList);
    }

    public void goToWomensEvents(View view) {
        goToUrl("https://calendar.google.com/calendar/embed?src=gk1i4ldl2aqa1rlkhpoom4os28%40group.calendar.google.com&ctz=America/Toronto");

    }

    public void goToSocialMedia(View view) {
        Intent socialMedia = new Intent(this, SocialMedia.class);
        startActivity(socialMedia);
    }

    private void goToUrl(String link) {
        Uri calLink = Uri.parse(link);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, calLink);
        startActivity(launchBrowser);
    }
}
