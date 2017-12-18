package com.example.george.trivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ready extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);

        Button start = (Button) findViewById(R.id.startButton);
        TextView list = (TextView) findViewById(R.id.playerList);
        //list.setText("asdasd");


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Ready.this, game.class);
                startActivity(myIntent);
            }
        });



    }
}
