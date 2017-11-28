package com.example.android.wicsapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SocialMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
    }

    public void goToFbPage(View view) {
        goToUrl("https://www.facebook.com/UWWICS/");
    }

    public void goToFbGroup(View view) {
        goToUrl("https://www.facebook.com/groups/wicsUW/");
    }

    public void goToUGradFbPage (View view) {
        goToUrl("https://www.facebook.com/wicsuw/");
    }

    public void goToUgradIg (View view) {
        goToUrl("https://instagram.com/wicsugrad");
    }

    public void goToUgradTwitter (View view) {
        goToUrl("https://twitter.com/wicsuw");
    }

    private void goToUrl(String link) {
        Uri calLink = Uri.parse(link);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, calLink);
        startActivity(launchBrowser);
    }
}
