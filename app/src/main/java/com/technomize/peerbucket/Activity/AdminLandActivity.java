package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.technomize.peerbucket.R;

public class AdminLandActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout addRemovePeopleLayout,addRemoveAdministratorsLayout,addRemoveAccountOwnerLayout,renameAccountLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_land);

        initUI();
    }

    private void initUI () {
        addRemovePeopleLayout = findViewById(R.id.add_remove);
        addRemoveAdministratorsLayout = findViewById(R.id.add_remove_administrators);
        addRemoveAccountOwnerLayout = findViewById(R.id.add_remove_account_owner);
        renameAccountLayout = findViewById(R.id.rename_account);

        renameAccountLayout.setOnClickListener(this);
        addRemoveAccountOwnerLayout.setOnClickListener(this);
        addRemoveAdministratorsLayout.setOnClickListener(this);
        addRemovePeopleLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.add_remove:
                Intent intent = new Intent(this,AddRemovePeopleChangeAccessActivity.class);
                startActivity(intent);
                break;

            case R.id.add_remove_administrators:
                intent = new Intent(this,AddRemoveAdministratorsActivity.class);
                startActivity(intent);
                break;

            case R.id.add_remove_account_owner:
                intent = new Intent(this,AddRemoveAccoutOwnerActivity.class);
                startActivity(intent);
                break;

            case R.id.rename_account:
                intent = new Intent(this,RenameAccountActivity.class);
                startActivity(intent);
                break;
        }
    }
}
