package com.example.cmse419_17300186_quiz5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Add_User extends AppCompatActivity {
    Button buttonAdd;
    EditText editTextUserNameAdd ,editTextPasswordAdd;
    ArrayList<String> list = new ArrayList<>();

    String filename="17300186.txt";
    FileOutputStream fos= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__user);

        buttonAdd = findViewById(R.id.buttonAdd);

        editTextPasswordAdd = findViewById(R.id.editTextPasswordAdd);
        editTextUserNameAdd = findViewById(R.id.editTextUserNameAdd);


        try {
            fos = openFileOutput(filename, Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add-write text into file
                try {

                    String text=editTextUserNameAdd.getText().toString()+" "+editTextPasswordAdd.getText().toString()+"\n";
                    fos.write(text.getBytes());


                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Add_User.this,MainActivity.class);
                startActivity(intent);
            }



        });



    }
}