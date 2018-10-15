package com.technomize.peerbucket.Activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class ChangeAvatarActivity extends AppCompatActivity implements View.OnClickListener {

    TextView changeAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_avatar);

        changeAvatar = findViewById(R.id.change_avatar);
        changeAvatar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.change_avatar:
                AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(this);

                LayoutInflater inflater1 = this.getLayoutInflater();
                View dialogView1 = inflater1.inflate(R.layout.dialog_remove_avatar, null);
                dialogBuilder1.setView(dialogView1);
                TextView close = dialogView1.findViewById(R.id.cancel);
                TextView remove = dialogView1.findViewById(R.id.remove);

                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.show();

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog1.dismiss();
                    }
                });

                remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog1.dismiss();
                    }
                });

                break;

        }
    }
}
