package com.gdg.bhopal.admissionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThankYouActivity extends AppCompatActivity {
    TextView thankyouTV;
    ArrayList<AdmissionApp> admissionApps;
    FormAdapter fadapter;
    RecyclerView formRCV;
    Button viewAdmissionBtn;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thank_you );
        thankyouTV = findViewById( R.id.thankyouTV );
        viewAdmissionBtn = findViewById( R.id.viewAdmissionBtn );
        logoutBtn = findViewById( R.id.logoutBtn );

        String name = getIntent().getStringExtra( "name" );
        admissionApps = new ArrayList<AdmissionApp>();
        AdmissionApp ad = (AdmissionApp)getIntent().getSerializableExtra( "details" );
        admissionApps.add( ad );
        fadapter = new FormAdapter( this, admissionApps );

        FormAdapter.admissionApp.add(ad);
        formRCV = (RecyclerView)findViewById( R.id. viewRecyclerView);
        formRCV.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
        formRCV.setAdapter(fadapter);
        fadapter.notifyDataSetChanged();
        thankyouTV.setText( thankyouTV.getText()+" "+name );

        viewAdmissionBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent( ThankYouActivity.this,ViewActivity.class );
                startActivity( i1 );
            }
        } );
        logoutBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent( ThankYouActivity.this,LoginActivity.class );
                startActivity( i2 );
            }
        } );
    }
}
