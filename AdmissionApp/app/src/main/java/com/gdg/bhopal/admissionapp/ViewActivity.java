package com.gdg.bhopal.admissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ArrayList<AdmissionApp>admissionList;
    DBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view );
        admissionList = new ArrayList<AdmissionApp>( );
        dbHelper = new DBHelper( this );
        admissionList = dbHelper.getAllAdmissionDetail();
    }
}
