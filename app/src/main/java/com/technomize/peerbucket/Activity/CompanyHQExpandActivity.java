package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.technomize.peerbucket.Adapter.ActivityScreenAdapter;
import com.technomize.peerbucket.R;

public class CompanyHQExpandActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private CardView mcv_search_expand,automaticCheckin,docsAndFiles,schedule,toDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_hqexpand);

        initUI();
        //initToolbar();
        initRecyclerView();
    }

    private void initUI () {
        mcv_search_expand = findViewById(R.id.cv_search_expand);
        automaticCheckin = findViewById(R.id.card_automatic_check_in);
        docsAndFiles = findViewById(R.id.card_docs_and_files);
        schedule = findViewById(R.id.card_schedule);
        toDo = findViewById(R.id.card_todo);

        docsAndFiles.setOnClickListener(this);
        automaticCheckin.setOnClickListener(this);
        schedule.setOnClickListener(this);
        toDo.setOnClickListener(this);
    }

    private void initRecyclerView () {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ActivityScreenAdapter adapter = new ActivityScreenAdapter();
        recyclerView.setAdapter(adapter);

    }

    private void initToolbar () {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.card_automatic_check_in:
                intent = new Intent(this,AutomaticCheckinActivity.class);
                startActivity(intent);
                break;

            case R.id.card_docs_and_files:
                intent = new Intent(this,DocsAndFilesActivity.class);
                startActivity(intent);
                break;

            case R.id.card_schedule:
                intent = new Intent(this,ScheduleActivity.class);
                startActivity(intent);
                break;

            case R.id.card_todo:
                intent = new Intent(this,ToDoActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                mcv_search_expand.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
