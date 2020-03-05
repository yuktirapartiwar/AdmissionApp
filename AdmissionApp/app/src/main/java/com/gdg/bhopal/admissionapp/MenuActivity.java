package com.gdg.bhopal.admissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu );
        Button registrationBtn = findViewById( R.id.registrationBtn );
        registrationBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MenuActivity.this, MainActivity.class );
                startActivity( intent );
            }
        } );
        Button viewBtn = findViewById( R.id.viewBtn );
        viewBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MenuActivity.this, ViewActivity.class );
                startActivity( intent );

            }
        } );
    }
}
