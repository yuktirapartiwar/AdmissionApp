package com.gdg.bhopal.admissionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FormAdapter extends RecyclerView.Adapter <FormAdapter.FormViewHolder> {

    static ArrayList<AdmissionApp> admissionApp;
    Context context;

    public FormAdapter(Context context, ArrayList<AdmissionApp>formList){
        admissionApp = formList;
        this.context = context;
        //AdmissionApp a = new AdmissionApp( "abc","be","xyz","pqr","rst","govt. job","20000","01012000","gen","bhopal",1234567890 );
        //admissionApp.add( a );
    }


    class FormViewHolder extends RecyclerView.ViewHolder{

        TextView  name, father_name, dob, category;

        public FormViewHolder(@NonNull View itemView) {
            super( itemView );
            name = (TextView)itemView.findViewById( R.id.studentTV );
            father_name = (TextView)itemView.findViewById( R.id.fathersNameTV );
            dob = (TextView)itemView.findViewById( R.id.dobTV );
            category = (TextView)itemView.findViewById( R.id.categoryTV );

        }
    }
    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_layout, parent,false );
        return new FormViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
        AdmissionApp ad = admissionApp.get( position );
        if(ad!=null) {
            holder.name.setText( ad.student_name );
            holder.father_name.setText( ad.father_name );
            holder.category.setText( ad.category );
            holder.dob.setText( ad.dob );
        }

    }

    @Override
    public int getItemCount() {
        return admissionApp.size();
    }



}
