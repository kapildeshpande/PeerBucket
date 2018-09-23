package com.technomize.peerbucket.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class SetupAccountActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout step1Layout,step2Layout,step3Layout,step4Layout;
    TextView nextStep1,nextStep2,nextStep3,nextStep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_account);

        step1Layout = findViewById(R.id.step1_layout);
        step2Layout = findViewById(R.id.step2_layout);
        step3Layout = findViewById(R.id.step3_layout);
        step4Layout = findViewById(R.id.step4_layout);

        nextStep1 = findViewById(R.id.next_step1);
        nextStep2 = findViewById(R.id.next_step2);
        nextStep3 = findViewById(R.id.next_step3);
        nextStep4 = findViewById(R.id.next_step4);

        nextStep1.setOnClickListener(this);
        nextStep2.setOnClickListener(this);
        nextStep3.setOnClickListener(this);
        nextStep4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.next_step1:
                step1Layout.setVisibility(View.GONE);
                step2Layout.setVisibility(View.VISIBLE);
                break;

            case R.id.next_step2:
                step2Layout.setVisibility(View.GONE);
                step3Layout.setVisibility(View.VISIBLE);
                break;

            case R.id.next_step3:
                step3Layout.setVisibility(View.GONE);
                step4Layout.setVisibility(View.VISIBLE);
                break;

            case R.id.next_step4:
                break;
        }
    }

}
