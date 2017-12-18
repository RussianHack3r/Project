package com.example.george.trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;


import java.net.Socket;
import java.util.Scanner;
import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Trivia extends AppCompatActivity {

    private static final int SERVERPORT = 2010;
    private static final String SERVER_IP = "54.167.215.132";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

      Button begin = (Button) findViewById(R.id.beginButton);
      EditText name = (EditText) findViewById(R.id.userNameEditText);



    String str =  name.getText().toString()+ " 0 "  ;


    Scanner msg = new Scanner(str);

// turn the name into raw data

    byte[] bytes = str.getBytes();
    StringBuilder binary = new StringBuilder();
    for (byte b : bytes) {
        int val = b;
        for (int i = 0; i < 8; i++) {
            binary.append((val & 128) == 0 ? 0 : 1);
            val <<= 1;
        }
        binary.append(msg);
    }

        //connect to server
        try {

            InetAddress address = InetAddress.getByName(SERVER_IP);

            Socket s = new Socket(address, SERVERPORT);


            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

           String sendMessage = msg + "\n";
            bw.write(sendMessage);
            bw.flush();

            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();



        } catch (Exception exception) {
            exception.printStackTrace();
        }

        // go to next screen
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Trivia.this, Ready.class);
                startActivity(myIntent);
            }
        });



      }

    }

