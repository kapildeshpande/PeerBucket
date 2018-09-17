package com.technomize.peerbucket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeciderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);
        mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.login_button:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}
