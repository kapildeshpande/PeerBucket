package com.technomize.peerbucket.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.technomize.peerbucket.Adapter.DateEventAdapter;
import com.technomize.peerbucket.Adapter.ToDoAdapter;
import com.technomize.peerbucket.R;

public class ToDoActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        initRecyclerView();
    }

    private void initRecyclerView () {
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ToDoAdapter toDoAdapter = new ToDoAdapter();
        recyclerView.setAdapter(toDoAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fab:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_add_todo, null);
                dialogBuilder.setView(dialogView);

                TextView mDialogCancel = (TextView) dialogView.findViewById(R.id.cancel);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                mDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;

        }
    }

}
}
