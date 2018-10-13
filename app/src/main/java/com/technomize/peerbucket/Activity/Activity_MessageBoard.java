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
import android.widget.Toast;

import com.technomize.peerbucket.R;

import org.w3c.dom.Text;

/**
 * Created by rishi on 10/10/2018.
 */

public class Activity_MessageBoard extends AppCompatActivity implements View.OnClickListener {

    TextView mmessage_board_sort_end,mback_arrow_msg_box,mdialog_message_type_announcements,
    mdialog_message_type_heartbeats,mdialog_message_type_pitches,mdialog_message_type_questions,
    mdialog_message_type_fyis,mmessage_board_sort_type,mmessage_board_start,mdialog_message_type_all_messages_text,mdialog_message_type_all_announcements_text,
    mdialog_message_type_all_heartbeats_text,mdialog_message_type_all_pitches_text,mdialog_message_type_all_questions_text,mdialog_message_type_all_fyis_text;
    Typeface fontTF;
    LinearLayout mmessage_sort_LL,mdialog_message_type_all_messagesLL,mdialog_message_type_announcementsLL,mdialog_message_type_heartbeatsLL,
    mdialog_message_type_pitchesLL,mdialog_message_type_questionsLL,mdialog_message_type_fyisLL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_board);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mmessage_board_sort_end=(TextView) findViewById(R.id.message_board_sort_end);
        mback_arrow_msg_box=(TextView) toolbar.findViewById(R.id.back_arrow_chat_box);
        mmessage_sort_LL=(LinearLayout) findViewById(R.id.message_sort_LL);
        mmessage_board_sort_type=(TextView) findViewById(R.id.messgae_board_sort_type);
        mmessage_board_start=(TextView) findViewById(R.id.message_board_start);


        fontTF=Typeface.createFromAsset(getAssets(), "font/fawsmsolid.ttf");

        mmessage_board_sort_end.setTypeface(fontTF);
        mback_arrow_msg_box.setTypeface(fontTF);
        mmessage_board_start.setTypeface(fontTF);

        mback_arrow_msg_box.setText("\uF060");
        mmessage_board_sort_end.setText("\uF0DC");

        mmessage_sort_LL.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_sort_LL:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_message_type, null);
                dialogBuilder.setView(dialogView);

                mdialog_message_type_announcements=(TextView) dialogView.findViewById(R.id.dialog_message_type_announcements);
                mdialog_message_type_heartbeats=(TextView) dialogView.findViewById(R.id.dialog_message_type_heartbeats);
                mdialog_message_type_pitches=(TextView) dialogView.findViewById(R.id.dialog_message_type_pitches);
                mdialog_message_type_questions=(TextView) dialogView.findViewById(R.id.dialog_message_type_questions);
                mdialog_message_type_fyis=(TextView) dialogView.findViewById(R.id.dialog_message_type_fyis);
                mdialog_message_type_all_messagesLL=(LinearLayout) dialogView.findViewById(R.id.dialog_message_type_all_messagesLL); 
                mdialog_message_type_announcementsLL= (LinearLayout) dialogView.findViewById(R.id.dialog_message_type_announcementsLL);
                mdialog_message_type_heartbeatsLL=(LinearLayout) dialogView.findViewById(R.id.dialog_message_type_heartbeatsLL);
                mdialog_message_type_pitchesLL=(LinearLayout)dialogView.findViewById(R.id.dialog_message_type_pitchesLL);
                mdialog_message_type_questionsLL=(LinearLayout) dialogView.findViewById(R.id.dialog_message_type_questionsLL);
                mdialog_message_type_fyisLL=(LinearLayout) dialogView.findViewById(R.id.dialog_message_type_fyisLL);

                mdialog_message_type_all_messages_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_messages_text);
                mdialog_message_type_all_announcements_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_announcements_text);
                mdialog_message_type_all_heartbeats_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_heartbeats_text);
                mdialog_message_type_all_pitches_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_pitches_text);
                mdialog_message_type_all_questions_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_questions_text);
                mdialog_message_type_all_fyis_text=(TextView) dialogView.findViewById(R.id.dialog_message_type_all_fyis_text);

                mdialog_message_type_announcements.setTypeface(fontTF);
                mdialog_message_type_heartbeats.setTypeface(fontTF);
                mdialog_message_type_pitches.setTypeface(fontTF);
                mdialog_message_type_questions.setTypeface(fontTF);
                mdialog_message_type_fyis.setTypeface(fontTF);

                mdialog_message_type_announcements.setText("\uF0A1");
                mdialog_message_type_heartbeats.setText("\uF004");
                mdialog_message_type_pitches.setText("\uF0EB");
                mdialog_message_type_questions.setText("\uF128");
                mdialog_message_type_fyis.setText("\uF0D0");
                
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                
                /*All Listeners here */
                
                mdialog_message_type_all_messagesLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_all_messsages);
                        mmessage_board_start.setText("");
                        alertDialog.dismiss();

                    }
                });
                
                mdialog_message_type_announcementsLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_announcements);
                        mmessage_board_start.setText("\uF0A1");
                        alertDialog.dismiss();

                    }
                });

                mdialog_message_type_heartbeatsLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_heartbeats);
                        mmessage_board_start.setText("\uF004");
                        alertDialog.dismiss();


                    }
                });

                mdialog_message_type_pitchesLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_pitches);
                        mmessage_board_start.setText("\uF0EB");
                        alertDialog.dismiss();

                    }
                });

                mdialog_message_type_questionsLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_questions);
                        mmessage_board_start.setText("\uF128");
                        alertDialog.dismiss();


                    }
                });

                mdialog_message_type_fyisLL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mmessage_board_sort_type.setText(R.string.dialog_FYI);
                        mmessage_board_start.setText("\uF0D0");
                        alertDialog.dismiss();

                    }
                });

                /*Active text Check*/

                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_all_messsages))){
                    mdialog_message_type_all_messages_text.setTypeface(null,Typeface.BOLD);
                    mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_questions_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.NORMAL);
                }
                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_announcements))){
                    mdialog_message_type_all_messages_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.BOLD);
                    mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_questions_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.NORMAL);
                }
                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_heartbeats))){
                    mdialog_message_type_all_messages_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.BOLD);
                    mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_questions_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.NORMAL);

                }
                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_pitches))){
                mdialog_message_type_all_messages_text.setTypeface(null,Typeface.NORMAL);
                mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.NORMAL);
                mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.NORMAL);
                mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.BOLD);
                mdialog_message_type_all_questions_text.setTypeface(null,Typeface.NORMAL);
                mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.NORMAL);
                }
                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_questions))){
                    mdialog_message_type_all_messages_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_questions_text.setTypeface(null,Typeface.BOLD);
                    mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.NORMAL);
                }
                if(mmessage_board_sort_type.getText().toString().equals(getString(R.string.dialog_FYI))){
                    mdialog_message_type_all_messages_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_announcements_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_heartbeats_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_pitches_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_questions_text.setTypeface(null,Typeface.NORMAL);
                    mdialog_message_type_all_fyis_text.setTypeface(null,Typeface.BOLD);
                }

                break;

        }
    }
}
