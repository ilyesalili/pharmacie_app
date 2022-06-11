package com.example.acsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;



public class RegisterActivity extends AppCompatActivity {
    Button btn_signup;
    FirebaseAuth mauth;
    EditText nom , prenom , email_signUp , password_signUp , number_phone , address;
    TextView toLogin;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nom=findViewById(R.id.ajouter_au_panier_btn);
        prenom=findViewById(R.id.prenom);
        number_phone=findViewById(R.id.number_phone);
        email_signUp=findViewById(R.id.email_signUp);
        password_signUp=findViewById(R.id.password_signUp);
        address=findViewById(R.id.address);
        btn_signup=findViewById(R.id.btn_signup);
        toLogin=findViewById(R.id.toLogin);



        toLogin.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));

        mauth=FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        btn_signup.setOnClickListener(v -> {
            if (nom.getText().toString().equals(""))
            {
                emptyError(nom , "empty");
            }else if (prenom.getText().toString().equals(""))
            {
                emptyError(prenom , "empty");
            }else if (number_phone.getText().toString().equals(""))
            {
                emptyError(number_phone , "empty");
            }
            else if (email_signUp.getText().toString().equals(""))
            {
                emptyError(email_signUp , "empty");
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email_signUp.getText().toString()).matches())
            {
                emptyError(email_signUp,"wrong email");
            }
            else if (password_signUp.getText().toString().equals("")){
                emptyError(password_signUp , "empty");
            }
            else if (address.getText().toString().equals("")){
                emptyError(address , "empty");
            } else{
                User user= new User(
                        "",
                        email_signUp.getText().toString(),
                        password_signUp.getText().toString(),
                        prenom.getText().toString(),
                        nom.getText().toString(),
                        number_phone.getText().toString(),
                        address.getText().toString(),
                        false
                );
                //le nom en fire base:

                user.SingUp(user, mauth , RegisterActivity.this,database);

            }
        });
    }


    private void emptyError(EditText editText , String error){
        editText.setError(error);
        editText.requestFocus();
    }
}