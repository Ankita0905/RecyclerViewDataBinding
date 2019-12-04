package com.example.recyclerviewdatabinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdatabinding.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{
    private Context context;
    private List<Users> users;

    public RecyclerAdapter(Context context, List<Users> users)
    {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       ItemLayoutBinding itemLayoutBinding= DataBindingUtil.inflate(
               LayoutInflater.from(viewGroup.getContext())
               ,R.layout.item_layout,viewGroup,false);

       MyViewHolder myViewHolder=new MyViewHolder(itemLayoutBinding);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i)
    {
        Users user=users.get(i);
        viewHolder.itemLayoutBinding.setUser(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        ItemLayoutBinding itemLayoutBinding;


        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            itemLayoutBinding=itemView;
        }
    }
}
