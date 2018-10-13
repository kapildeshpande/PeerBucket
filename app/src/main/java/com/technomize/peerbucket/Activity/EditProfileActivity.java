package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.technomize.peerbucket.R;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout timezoneLayout,weekLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_layout);

        timezoneLayout = findViewById(R.id.relative_layout1);
        weekLayout = findViewById(R.id.relative_layout2);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.relative_layout1:
//                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//
//                LayoutInflater inflater = this.getLayoutInflater();
//                View dialogView = inflater.inflate(R.layout.dialog_tcp_expand, null);
//                dialogBuilder.setView(dialogView);
//
//                final AlertDialog alertDialog = dialogBuilder.create();
//                alertDialog.show();
//                break;

        }
    }
}
