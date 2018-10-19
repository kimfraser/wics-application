package com.example.android.wicsapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.sql.Ref;

public class EventPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        final ImageView mImageView = (ImageView) findViewById(R.id.eventimage);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://wics-application.appspot.com");
        StorageReference folderRef = storageRef.child("event_images");
        StorageReference imageRef = folderRef.child("SpeedMentoring.png");

        try {
            final File localFile = File.createTempFile("images", "png");
            storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    mImageView.setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                }
            });
        } catch (IOException e ) {}
        //setContentView(R.layout.activity_event_page);
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
