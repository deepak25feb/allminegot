package com.example.firebasetest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    int Image1;
    int Image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("name_name");
        ImageView imageView1 = findViewById(R.id.image1);
        ImageView imageView2 = findViewById(R.id.image2);
        TextView textview = findViewById(R.id.text1);
        Button b1 = findViewById(R.id.button1);

        FirebaseDatabase.getInstance().getReference().child(user_name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Image1 = snapshot.child("image1").getValue(Integer.class);
                Image2 = snapshot.child("image2").getValue(Integer.class);
                imageView1.setImageResource(Image1);
                imageView2.setImageResource(Image2);
                Log.i("CHECK",Image1+":"+Image2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().child(user_name).child("image1").setValue(R.drawable.checkbok_green);
            }
        });

//        imageView1.setImageResource(Image1);
//        imageView2.setImageResource(Image2);
        textview.setText(user_name);



    }
}