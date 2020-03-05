package com.gdg.bhopal.admissionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    EditText nameInsEdt, courseEdt, nameEdt, fathersNameEdt, mothersnameEdt, incomeEdt, dobEdt, addressEdt, mobileEdt ;
    CheckBox govtCB, privateCB, businessCB, otherCB;
    RadioButton genRB, obcRB, stRB, scRB;
    DBHelper dbHelper = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        nameInsEdt = (EditText)findViewById( R.id.nameInsEdt );
        courseEdt = (EditText)findViewById( R.id.courseEdt );
        nameEdt = (EditText)findViewById( R.id.nameEdt );
        fathersNameEdt = (EditText)findViewById( R.id.fathersNameEdt );
        mothersnameEdt = (EditText)findViewById( R.id.mothersNameEdt );
        incomeEdt = (EditText)findViewById( R.id.incomeEdt );
        dobEdt = (EditText)findViewById( R.id.dobEdt );
        addressEdt = (EditText)findViewById( R.id.addressEdt );
        mobileEdt = (EditText)findViewById( R.id.mobileEdt );
        govtCB = (CheckBox)findViewById( R.id.govtCB );
        privateCB = (CheckBox)findViewById( R.id.privateCB );
        businessCB = (CheckBox)findViewById( R.id.businessCB );
        otherCB = (CheckBox)findViewById( R.id.otherCB );
        genRB = (RadioButton)findViewById( R.id.genRB );
        obcRB = (RadioButton)findViewById( R.id.obcRB );
        stRB = (RadioButton)findViewById( R.id.stRB );
        scRB = (RadioButton)findViewById( R.id.scRB );
        submitBtn = findViewById( R.id.submitBtn );

        dbHelper = new DBHelper( this );

        submitBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String institute = nameInsEdt.getText().toString();
                String course = courseEdt.getText().toString();
                String name = nameEdt.getText().toString();
                String fathersName = fathersNameEdt.getText().toString();
                String mothersName = mothersnameEdt.getText().toString();
                String income = incomeEdt.getText().toString();
                String dob = dobEdt.getText().toString();
                String address = addressEdt.getText().toString();
                String mobile = mobileEdt.getText().toString();
                String occupation = null;
                if(govtCB.isChecked()){
                    occupation = "Govt. job";
                }
                if(privateCB.isChecked()){
                    occupation = "Private job";
                }
                if(businessCB.isChecked()){
                    occupation = "Businessman";
                }
                if(otherCB.isChecked()){
                    occupation = "Other";
                }
                String category = null;
                if(genRB.isChecked()){
                    category = "General";
                }
                if(obcRB.isChecked()){
                    category = "OBC";
                }
                if(scRB.isChecked()){
                    category = "SC";
                }
                if(stRB.isChecked()){
                    category = "ST";
                }
                AdmissionApp ad = new AdmissionApp( institute, course, name,fathersName,mothersName,income,dob,address,mobile,occupation,category );

                boolean isInserted = dbHelper.insertDetails(ad);
                if(isInserted){
                    Toast.makeText( getApplicationContext(),"Feedback received successfully!!" ,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText( getApplicationContext(),"Error Occured", Toast.LENGTH_LONG ).show();
                }

                Intent intent = new Intent( MainActivity.this,ThankYouActivity.class );
                intent.putExtra( "name",nameEdt.getText().toString() );
                intent.putExtra( "details", ad );
                startActivity( intent );
            }
        } );
    }
}
