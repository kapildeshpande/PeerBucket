package com.technomize.peerbucket.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.technomize.peerbucket.R;

/**
 * Created by rishi on 10/10/2018.
 */

public class Activity_MessageBoard extends AppCompatActivity implements View.OnClickListener {

    TextView mmessage_board_sort_end,mback_arrow_msg_box;
    Typeface fontTF;
    LinearLayout mmessage_sort_LL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_board);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mmessage_board_sort_end=(TextView) findViewById(R.id.message_board_sort_end);
        mback_arrow_msg_box=(TextView) toolbar.findViewById(R.id.back_arrow_chat_box);
        mmessage_sort_LL=(LinearLayout) findViewById(R.id.message_sort_LL);


        fontTF=Typeface.createFromAsset(getAssets(), "font/fawsmsolid.ttf");

        mmessage_board_sort_end.setTypeface(fontTF);
        mback_arrow_msg_box.setTypeface(fontTF);

        mback_arrow_msg_box.setText("\uF060");
        mmessage_board_sort_end.setText("\uF0DC");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_sort_LL:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_current_user, null);
                dialogBuilder.setView(dialogView);

                TextView edit_image=dialogView.findViewById(R.id.edit_image);
                TextView timezoneTv=dialogView.findViewById(R.id.user_time_and_timezone);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                break;
        }
    }
}
