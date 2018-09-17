package com.technomize.peerbucket;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView navigateBack;
    private LinearLayout mainLayout,forgotPasswordLayout;
    private EditText emailText;
    private Button navigateNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        navigateBack = findViewById(R.id.navigate_back);
        navigateBack.setOnClickListener(this);

        mainLayout = findViewById(R.id.main_layout);
        forgotPasswordLayout = findViewById(R.id.forgot_password_layout);
        emailText = findViewById(R.id.email);
        navigateNext = findViewById(R.id.navigate_next);

        navigateNext.setOnClickListener(this);
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
                if (isEmailValid(emailText.getText().toString())) {
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    mainLayout.setVisibility(View.GONE);
                    forgotPasswordLayout.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this,"Email is not valid", Toast.LENGTH_SHORT).show();
                }
                break;
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
