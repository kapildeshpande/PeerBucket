package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class AddRemovePeopleActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView closeInviteLayout;
    private LinearLayout inviteLayout;
    private RelativeLayout relativeLayout;
    private TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove_people);

        initUI();

    }

    private void initUI () {

        closeInviteLayout = findViewById(R.id.close);
        inviteLayout = findViewById(R.id.invite_layout);
        relativeLayout = findViewById(R.id.relative_layout1);
        edit = findViewById(R.id.edit);

        edit.setOnClickListener(this);
        closeInviteLayout.setOnClickListener(this);
        inviteLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.invite_layout:
                if (relativeLayout.getVisibility() == View.GONE) {
                    relativeLayout.setVisibility(View.VISIBLE);
                } else {
                    relativeLayout.setVisibility(View.GONE);
                }
                break;

            case R.id.close:
                if (relativeLayout.getVisibility() == View.GONE) {
                    relativeLayout.setVisibility(View.VISIBLE);
                } else {
                    relativeLayout.setVisibility(View.GONE);
                }
                break;

            case R.id.edit:
                Intent intent = new Intent(this,EditPeopleActivity.class);
                startActivity(intent);
                break;
        }
    }
}
