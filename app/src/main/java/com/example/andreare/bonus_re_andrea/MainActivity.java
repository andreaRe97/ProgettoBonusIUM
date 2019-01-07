package com.example.andreare.bonus_re_andrea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView register;

    TextView errorText;

    User person = new User();

    public static final String USER_EXTRA = "com.example.andreare.bonus_re_andrea.User";

    UserFactory factory = UserFactory.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.confirm);
        register = (TextView) findViewById(R.id.register);

        errorText = (TextView) findViewById(R.id.errorText);
        errorText.setVisibility(View.GONE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {
                    person.setUsername("" + username.getText());
                    person.setPassword("" + password.getText());

                    Intent showResults = new Intent(MainActivity.this, ShowResults.class);

                    showResults.putExtra(USER_EXTRA, factory.isIn(person) ? person.toString() : "");

                    startActivity(showResults);

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rAct = new Intent(MainActivity.this, com.example.andreare.bonus_re_andrea.Register.class);

                rAct.putExtra(USER_EXTRA, person);

                startActivity(rAct);
            }
        });
    }

    private boolean checkInput() {
        int errors = 0;

        if(username.getText() == null || username.getText().length() == 0) {
            username.setError("Inserire username");
            errors++;
        }
        else
            errorText.setError(null);

        if(password.getText()==null || password.getText().length()==0) {
            password.setError("Inserire password");
            errors++;
        }
        else
            errorText.setError(null);
        switch (errors){
            case 0:
                errorText.setVisibility(View.GONE);
                errorText.setText("");
                break;
            case 1:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Inserisci entrambi i campi");
                break;
            default:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Non hai compilato " + errors+" campi" );
                break;
        }

        return errors == 0;

    }


}
