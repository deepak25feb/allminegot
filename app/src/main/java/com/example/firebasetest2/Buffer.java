package com.example.firebasetest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Buffer extends AppCompatActivity {
    Boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer);


        Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                b = snapshot.hasChild(name);
                if(b){}else{
                    Model model = new Model(R.drawable.ic_baseline_check_box_24,R.drawable.ic_baseline_check_box_24);
                    FirebaseDatabase.getInstance().getReference().child(name).setValue(model);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        Handler handler = new Handler();






        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Buffer.this,HomeActivity.class).putExtra("name_name",name));
            }
        },2000);

    }
}