package com.example.recylerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecylerContactAdapter extends RecyclerView.Adapter<RecylerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactMode> arrContacts;
     RecylerContactAdapter(Context context, ArrayList<ContactMode> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;

    }

    public void setFilteredList(List<ContactMode> filteredList){
         this.arrContacts = (ArrayList<ContactMode>) filteredList;
         notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.imgContact.setImageResource(arrContacts.get(position).img);
          holder.txtName.setText(arrContacts.get(position).name);
          holder.txtNumber.setText(arrContacts.get(position).number);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

         TextView txtName, txtNumber;
         ImageView imgContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
        }
    }

}
