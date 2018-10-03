package com.technomize.peerbucket.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.technomize.peerbucket.Adapter.NewNotificationAdapter;
import com.technomize.peerbucket.Adapter.OldNotificationAdapter;
import com.technomize.peerbucket.R;

/**
 * Created by rishi on 10/1/2018.
 */

public class HeyActivity extends AppCompatActivity {

    private RecyclerView newNotiRecyclerView,oldNotiRecylerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hey);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initNewNotiRecyclerView();
        initOldNotiRecyclerView();
    }

    private void initNewNotiRecyclerView () {
        newNotiRecyclerView = findViewById(R.id.new_notification_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newNotiRecyclerView.setLayoutManager(linearLayoutManager);

        NewNotificationAdapter adapter = new NewNotificationAdapter();
        newNotiRecyclerView.setAdapter(adapter);

    }

    private void initOldNotiRecyclerView () {
        oldNotiRecylerView = findViewById(R.id.old_notification_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        oldNotiRecylerView.setLayoutManager(linearLayoutManager);

        OldNotificationAdapter adapter = new OldNotificationAdapter();
        oldNotiRecylerView.setAdapter(adapter);
    }

}
