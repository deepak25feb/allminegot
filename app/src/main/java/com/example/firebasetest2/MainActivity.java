package com.example.firebasetest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextTextPersonName);
        Button b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = text.getText().toString();

               // FirebaseDatabase.getInstance().getReference().child(name).setValue(model);
                startActivity(new Intent(MainActivity.this,Buffer.class).putExtra("name",name));
            }
        });
        //FirebaseDatabase.getInstance().getReference().child("").push().setValue(model);


    }
}