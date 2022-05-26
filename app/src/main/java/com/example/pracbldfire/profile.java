package com.example.pracbldfire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class profile extends AppCompatActivity {
    EditText name,Bloodgrp,Phone,Location;
    Button btnback,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=(EditText)findViewById(R.id.txtnme);
        Bloodgrp=(EditText)findViewById(R.id.txtBloodgrp);
        Phone=(EditText)findViewById(R.id.txtContact);
        Location=(EditText)findViewById(R.id.txtLocation);

        btnAdd=findViewById(R.id.btnsave);
        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(addActivity.this,MainActivity.class);
                startActivity(i);*/
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });
    }

    private void insertData(){
        Map<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("Blood group",Bloodgrp.getText().toString());
        map.put("Phone",Phone.getText().toString());
        map.put("Location",Location.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("bap").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>(){

                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(profile.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(profile.this, "Error while insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}