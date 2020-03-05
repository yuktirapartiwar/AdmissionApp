package com.gdg.bhopal.admissionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    static String DB_Name = "admissionapp.db";
    static int DB_Version = 2;

    public static String Table_Name = "view admission";
    public static String ID_COL = "ID";
    public static String INSTITUTE_COL = "INSTITUTE";
    public static String COURSE_COL = "COURSE";
    public static String NAME_COL = "NAME";
    public static String FATHERNAME_COL = "FATHER'S NAME";
    public static String MOTHERNAME_COL = "MOTHER'S NAME";
    public static String OCCUPATION_COL = "OCCUPATION";
    public static String INCOME_COL = "INCOME";
    public static String DOB_COL = "DOB";
    public static String CATEGORY_COL = "CATEGORY";
    public static String ADDRESS_COL = "ADDRESS";
    public static String MOBILE_COL = "MOBILE";

    public static String query = "create table "+Table_Name+"("+ID_COL+" integer primary key autoincrement, " +INSTITUTE_COL+" text"+
            " " +COURSE_COL+" text, " +NAME_COL+" text, " +FATHERNAME_COL+" text, " +MOTHERNAME_COL+" text, " +OCCUPATION_COL+" text, "+
            " " +INCOME_COL+" text, " +DOB_COL+" text, " +CATEGORY_COL+" text, " +ADDRESS_COL+" text, "+MOBILE_COL+" text)";

    public DBHelper(@Nullable Context context) {
        super( context, DB_Name, null, DB_Version );
    }

    public boolean insertDetails(AdmissionApp ad){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues(  );
            cv.put( INSTITUTE_COL,ad.institute_name );
            cv.put( COURSE_COL,ad.course );
            cv.put( NAME_COL,ad.student_name );
            cv.put( FATHERNAME_COL,ad.father_name );
            cv.put( MOTHERNAME_COL,ad.mother_name );
            cv.put( OCCUPATION_COL,ad.occupation );
            cv.put( INCOME_COL,ad.income );
            cv.put( DOB_COL,ad.dob );
            cv.put( CATEGORY_COL,ad.category );
            cv.put( ADDRESS_COL,ad.address );
            cv.put( MOBILE_COL,ad.mobile );
            db.insert( Table_Name, null,cv );
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public ArrayList<AdmissionApp>getAllAdmissionDetail(){
        ArrayList<AdmissionApp> adList = new ArrayList<AdmissionApp>();
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery( "SELECT * FROM " + Table_Name, null );
            while(c.moveToNext()){
                String institute = c.getString( c.getColumnIndex( INSTITUTE_COL ) );
                String course = c.getString( c.getColumnIndex( COURSE_COL ) );
                String name = c.getString( c.getColumnIndex( NAME_COL ) );
                String father = c.getString( c.getColumnIndex( FATHERNAME_COL ) );
                String mother = c.getString( c.getColumnIndex( MOTHERNAME_COL ) );
                String occupation = c.getString( c.getColumnIndex( OCCUPATION_COL ) );
                String income = c.getString( c.getColumnIndex( INCOME_COL ) );
                String dob = c.getString( c.getColumnIndex( DOB_COL ) );
                String category = c.getString( c.getColumnIndex( CATEGORY_COL ) );
                String address = c.getString( c.getColumnIndex( ADDRESS_COL ) );
                String mobile = c.getString( c.getColumnIndex( MOBILE_COL ) );
                AdmissionApp ad = new AdmissionApp( institute, course,name,father,mother,occupation,income,dob, category,address,mobile);
                adList.add( ad );
            }
        }catch (Exception ex){
            Log.e("ERROR",ex.toString());
        }
        return adList;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( query );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
