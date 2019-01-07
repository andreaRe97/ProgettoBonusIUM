package com.example.andreare.bonus_re_andrea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.Serializable;

public class ShowResults extends AppCompatActivity {

    TextView username;

    String result;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.USER_EXTRA);

        result = obj.toString();

        username = (TextView) findViewById(R.id.username);

        back = (Button) findViewById(R.id.back);

        username.setText(result.equals("") ? "ACCESS DENIED" : "WELCOME " + result + "!");


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                Intent showResults = new Intent(ShowResults.this,
                        MainActivity.class);

                startActivity(showResults);
            }
        });


    }
}
