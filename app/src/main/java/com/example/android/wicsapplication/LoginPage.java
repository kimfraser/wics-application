package com.example.android.wicsapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {

    private String watiam;
    private String password;
    public static boolean AUTH = false;

    EditText etPassword;
    CheckBox cbPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the password text
        etPassword = (EditText) findViewById(R.id.password);
        //get the checkbox
        cbPassword = (CheckBox) findViewById(R.id.pwCheckBox);

        cbPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(!isChecked) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
        etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());


    }

    public void goToAuthHomePage (View view) {
        EditText watiamEditable = (EditText)findViewById(R.id.watiam);
        EditText passwordEditable = (EditText)findViewById(R.id.password);

        watiam = watiamEditable.getText().toString();
        password = passwordEditable.getText().toString();

        boolean success = false;
        //authenticate

        //if successful, go to home page
        if(success) {

        } else {
            AlertDialog unsucessful = new AlertDialog.Builder(LoginPage.this).create();
            unsucessful.setTitle("Unsuccessful Login");
            unsucessful.setMessage("Incorrect WatIAM or Password. Please try again.");
            unsucessful.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            unsucessful.show();
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            passwordEditable.setText("");
        }

        //if unsuccessful, display error message
    }

    public void goToHomePage (View view)  {
        Intent homePage = new Intent(this, HomePage.class );
        startActivity(homePage);
    }
}
