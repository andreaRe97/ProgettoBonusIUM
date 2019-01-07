package com.example.andreare.bonus_re_andrea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class Register extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        back = (Button) findViewById(R.id.confirmregister);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                Intent reg = new Intent(Register.this,
                        MainActivity.class);

                startActivity(reg);
            }
        });

    }


}
