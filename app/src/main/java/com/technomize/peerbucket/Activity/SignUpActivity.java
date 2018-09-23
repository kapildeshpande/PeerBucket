package com.technomize.peerbucket.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.technomize.peerbucket.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rishi on 9/20/2018.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout forgotPasswordLayout,mainLayout;
    private ImageView navigateBack;
    private EditText email;
    private Button navigateNext,navigateNextPassword;
    private TextView mContactSupport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        forgotPasswordLayout = findViewById(R.id.forgot_password_layout);
        mainLayout = findViewById(R.id.main_layout);

        navigateBack = findViewById(R.id.navigate_back);

        email = findViewById(R.id.email);
        navigateNext =(Button) findViewById(R.id.navigate_next);
        navigateNextPassword = findViewById(R.id.next_password);

        navigateNext.setOnClickListener(this);
        navigateBack.setOnClickListener(this);
        navigateNextPassword.setOnClickListener(this);

        mContactSupport = findViewById(R.id.contact_support_tv);
        mContactSupport.setOnClickListener(this);
    }

    private static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.navigate_back:
                if (forgotPasswordLayout.getVisibility() == View.VISIBLE) {
                    forgotPasswordLayout.setVisibility(View.GONE);
                    mainLayout.setVisibility(View.VISIBLE);
                } else {
                    finish();
                }
                break;

            case R.id.navigate_next:
                if (isEmailValid(email.getText().toString())) {
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    mainLayout.setVisibility(View.GONE);
                    forgotPasswordLayout.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this,"Email is not valid", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.next_password:
                Intent intent = new Intent(this,SetupAccountActivity.class);
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
        }

    }

    @Override
    public void onBackPressed() {

        if (forgotPasswordLayout.getVisibility() == View.VISIBLE) {
            forgotPasswordLayout.setVisibility(View.GONE);
            mainLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}
