package com.technomize.peerbucket.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technomize.peerbucket.R;

public class DateEventAdapter extends RecyclerView.Adapter<DateEventAdapter.MyViewHolder>  {

    public  DateEventAdapter () {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_date_events, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;

        MyViewHolder (View v) {
            super(v);
            cardView = v.findViewById(R.id.card_date_event);
        }

    }
}