package com.example.cmse419_17300186_quiz5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    EditText editTextUserName,editTextPassword;

    Button buttonLogin, buttonNewUser;

    String filename="17300186.txt";
    ArrayList<String> list = new ArrayList<>();



    StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonNewUser = findViewById(R.id.buttonNewUser);

        //reading text from file
        try {
            String text="";
            FileInputStream fis=openFileInput(filename);
            int size=fis.available();
            byte[] buffer=new byte[size];
            fis.read(buffer);
            fis.close();
            text=new String(buffer);
            list = new ArrayList<String>(Arrays.asList(text.split("\n")));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }



            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(list.contains(editTextUserName.getText().toString() + " "+ editTextPassword.getText().toString())){
                        Toast.makeText(getBaseContext(), "Found!",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, UserPage.class);
                        intent.putExtra("UserName", editTextUserName.getText().toString());
                        intent.putExtra("Password", editTextPassword.getText().toString());
                        startActivity(intent);


                    }
                    else {
                        Toast.makeText(getBaseContext(), "Wrong Number or Password!",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            buttonNewUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Add_User.class);
                    startActivity(intent);
                }
            });

        }
    }
