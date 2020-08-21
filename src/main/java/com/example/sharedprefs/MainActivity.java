package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText EnterMessage;
    private Button saveButton;
    private TextView result;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterMessage = (EditText) findViewById(R.id.EnternameId);
        result = (TextView) findViewById(R.id.resultViewId);
        saveButton = (Button) findViewById(R.id.saveBtnId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPrefs = getSharedPreferences("PREFS_NAME",0); // mode level 0 // Name of File String final String4
                SharedPreferences.Editor editor = myPrefs.edit();

                // pass the data using key and value

                editor.putString("message",EnterMessage.getText().toString());
                editor.commit(); // commit means completely save the data with key




            }
        });

        // get the data back

        SharedPreferences prefs = getSharedPreferences("message", 0);
        if (prefs.contains("message")){
            String message = prefs.getString("message","not found");   // get the message back with key and set the default value not found
            result.setText("Message: "+ message);
        }
    }
}