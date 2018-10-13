package com.technomize.peerbucket.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.technomize.peerbucket.Adapter.DateEventAdapter;
import com.technomize.peerbucket.Adapter.NewNotificationAdapter;
import com.technomize.peerbucket.R;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView dateEventRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        initRecyclerView();
    }

    private void initRecyclerView () {
        dateEventRecyclerView = findViewById(R.id.date_event_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dateEventRecyclerView.setLayoutManager(linearLayoutManager);

        DateEventAdapter dateEventAdapter = new DateEventAdapter();
        dateEventRecyclerView.setAdapter(dateEventAdapter);

    }

}

}
