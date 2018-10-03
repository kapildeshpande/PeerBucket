package com.technomize.peerbucket.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class ActivityScreenAdapter extends RecyclerView.Adapter<ActivityScreenAdapter.MyViewHolder>  {

    public  ActivityScreenAdapter () {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_activity_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (position != 0) {
            holder.linearLayout.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;

        MyViewHolder (View v) {
            super(v);
            linearLayout = v.findViewById(R.id.linear_layout1);
        }

    }
}