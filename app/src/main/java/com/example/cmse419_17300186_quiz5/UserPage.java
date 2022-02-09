package com.example.cmse419_17300186_quiz5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserPage extends AppCompatActivity {

    TextView textViewUSerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        textViewUSerInfo = findViewById(R.id.textViewUSerInfo);

        Bundle bundle =getIntent().getExtras();

        if(bundle != null){

            textViewUSerInfo.setText(bundle.getString("UserName") + " " + bundle.getString("Password"));

        }

    }
}