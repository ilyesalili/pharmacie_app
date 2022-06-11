package com.example.acsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText email_login , password_login;
    TextView toSignUp;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        btn_login = findViewById(R.id.btn_login);
        toSignUp = findViewById(R.id.toSignUp);
        auth = FirebaseAuth.getInstance();

//
//        if (auth.getCurrentUser()!=null) {
//        startActivity(new Intent(LoginActivity.this , MainActivity.class));
//
//       }

        toSignUp.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

        btn_login.setOnClickListener(v -> {
            if (email_login.getText().toString().equals("")) {
                emptyError(email_login, "empty");
            } else if (password_login.getText().toString().equals("")) {
                emptyError(password_login, "empty");
            } else {
                User user = new User();
                user.login(email_login.getText().toString(), password_login.getText().toString() , auth , LoginActivity.this);
            }
        });


    }



    private void emptyError(EditText editText , String error){
        editText.setError(error);
        editText.requestFocus();
    }
}