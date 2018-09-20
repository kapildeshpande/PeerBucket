package com.technomize.peerbucket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeciderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLoginButton,mFreeTrial;
    private TextView mContactSupportTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);
        mLoginButton = findViewById(R.id.login_button);
        mContactSupportTv=findViewById(R.id.contact_support_tv);
        mFreeTrial=(Button)findViewById(R.id.free_trial_button);

        mLoginButton.setOnClickListener(this);
        mContactSupportTv.setOnClickListener(this);
        mFreeTrial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.login_button:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.contact_support_tv:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_support_team, null);
                dialogBuilder.setView(dialogView);

                TextView mDialogCancel = (TextView) dialogView.findViewById(R.id.contact_support_cancel_tv);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                mDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
            case R.id.free_trial_button:
                Intent ft_intent = new Intent(this,FreeTrialActivity.class);
                startActivity(ft_intent);
                break;
        }

    }
}
