package com.technomize.peerbucket.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.technomize.peerbucket.Adapter.ActivityScreenAdapter;
import com.technomize.peerbucket.R;

public class RecentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);

        initRecyclerView();
    }

    private void initRecyclerView () {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ActivityScreenAdapter adapter = new ActivityScreenAdapter();
        recyclerView.setAdapter(adapter);

    }
}
