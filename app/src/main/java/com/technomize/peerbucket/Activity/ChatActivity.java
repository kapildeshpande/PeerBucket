package com.technomize.peerbucket.Activity;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by rishi on 10/8/2018.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mattachment_chat_box,msend_chat_box,mback_arrow_chat_box,mchat_box_group;
    ImageView mchat_box_right_image,mimage_other_user_profile;
    Typeface fontTF;
    LinearLayout mchat_box_user_count_LL;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mchat_box_user_count_LL=(LinearLayout) toolbar.findViewById(R.id.chat_box_user_count_LL);

        mattachment_chat_box= (TextView)findViewById(R.id.attachment_chat_box);
        msend_chat_box=(TextView) findViewById(R.id.send_chat_box);
        mback_arrow_chat_box=(TextView) toolbar.findViewById(R.id.back_arrow_chat_box);
        mchat_box_group= (TextView) findViewById(R.id.chat_box_group);
        mchat_box_right_image=(ImageView) findViewById(R.id.chat_box_right_image);
        mimage_other_user_profile= (ImageView) findViewById(R.id.image_other_user_profile);

        fontTF= Typeface.createFromAsset(getAssets(), "font/fawsmsolid.ttf");
        mattachment_chat_box.setTypeface(fontTF);
        msend_chat_box.setTypeface(fontTF);
        mback_arrow_chat_box.setTypeface(fontTF);
        mchat_box_group.setTypeface(fontTF);

        mchat_box_group.setText("\uF500");
        mback_arrow_chat_box.setText("\uF060");
        msend_chat_box.setText("\uF138");
        mattachment_chat_box.setText("\uF0C6");


        mchat_box_right_image.setOnClickListener(this);
        mchat_box_user_count_LL.setOnClickListener(this);
        mimage_other_user_profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chat_box_right_image:

                Calendar cal = Calendar.getInstance();
                Date date=cal.getTime();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String formattedDate=dateFormat.format(date);
                String timezone= TimeZone.getDefault().getDisplayName();

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_current_user, null);
                dialogBuilder.setView(dialogView);

                TextView edit_image=dialogView.findViewById(R.id.edit_image);
                TextView timezoneTv=dialogView.findViewById(R.id.user_time_and_timezone);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                edit_image.setTypeface(fontTF);
                edit_image.setText("\uF303");
                timezoneTv.setText(formattedDate+" in "+timezone);

                break;

            case R.id.chat_box_user_count_LL:
                View view = getLayoutInflater().inflate(R.layout.bottom_sheet_chat_box, null);

                BottomSheetDialog dialog = new BottomSheetDialog(this);
                dialog.setContentView(view);
                dialog.show();
                break;

            case R.id.image_other_user_profile:
                dialogBuilder = new AlertDialog.Builder(this);
                 cal = Calendar.getInstance();
                 date=cal.getTime();
                 dateFormat = new SimpleDateFormat("HH:mm:ss");
                 formattedDate=dateFormat.format(date);
                 timezone= TimeZone.getDefault().getDisplayName();


                inflater = this.getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialog_other_user, null);
                dialogBuilder.setView(dialogView);
                alertDialog = dialogBuilder.create();
                alertDialog.show();

                timezoneTv=dialogView.findViewById(R.id.other_user_time_and_timezone);
                timezoneTv.setText(formattedDate+" in "+timezone);
                break;
        }
    }
}
