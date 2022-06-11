package com.example.acsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class popup extends AppCompatActivity {

    EditText name_med,qty_med;
    Button btn_ajou;

    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        name_med=findViewById(R.id.name_med);
        qty_med=findViewById(R.id.qty_med);
        btn_ajou=findViewById(R.id.btn_ajou);

        database= FirebaseDatabase.getInstance();
    }
}