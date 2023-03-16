package com.example.retrofitdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {
  Context context;
    List<UserModal> arrayList;
    public UserRecyclerAdapter(Context context, List<UserModal> arrayList) {
      this.context=context;
      this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=   LayoutInflater.from(context).inflate(R.layout.userlayout,parent,false);
     ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(arrayList.get(position).getId()));
        holder.name.setText(arrayList.get(position).getName());
        holder.email.setText(arrayList.get(position).getEmail());
        holder.userName.setText(arrayList.get(position).getUser_name());
        holder.street.setText(arrayList.get(position).address.getStreet());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
  TextView id,name,userName,email,street;

        public ViewHolder( View itemView) {

            super(itemView);
            id=itemView.findViewById(R.id.userId);
            name=itemView.findViewById(R.id.name);
            userName=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.userEmail);
            street=itemView.findViewById(R.id.userStreet);
        }
    }
}
