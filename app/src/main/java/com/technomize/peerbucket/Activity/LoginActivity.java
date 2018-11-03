package com.technomize.peerbucket.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
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

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.technomize.peerbucket.R;
import com.technomize.peerbucket.volley.ApiRequest;
import com.technomize.peerbucket.volley.IApiResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.technomize.peerbucket.ApiController.ApiConfigs.BASE_URL;
import static com.technomize.peerbucket.ApiController.ApiConfigs.CHECK_EMAIL;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, IApiResponse{

    private ImageView navigateBack;
    private LinearLayout mainLayout,forgotPasswordLayout;
    private EditText emailText,passwordText;
    private Button navigateNext,navigateNextPassword;
    private TextView mContactSupportTv;
    private ApiRequest mApiRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mApiRequest= new ApiRequest(this, (IApiResponse) this);

        navigateBack = findViewById(R.id.navigate_back);
        navigateBack.setOnClickListener(this);

        mainLayout = findViewById(R.id.main_layout);
        forgotPasswordLayout = findViewById(R.id.forgot_password_layout);
        emailText = findViewById(R.id.email);
        navigateNext = findViewById(R.id.navigate_next);
        navigateNextPassword = findViewById(R.id.forgot_password_layout_next);

        navigateNext.setOnClickListener(this);
        navigateNextPassword.setOnClickListener(this);

        mContactSupportTv = findViewById(R.id.contact_support_tv);
        mContactSupportTv.setOnClickListener(this);

        passwordText = findViewById(R.id.password_text);
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
                    Map<String, String> paramsReq = new HashMap<>();
                    paramsReq.put("email", emailText.getText().toString());
                    mApiRequest.postRequest(BASE_URL + CHECK_EMAIL, CHECK_EMAIL, paramsReq, Request.Method.POST);
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    mainLayout.setVisibility(View.GONE);
                    forgotPasswordLayout.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this,"Email is not valid", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.forgot_password_layout_next:

                if (passwordText.getText() == null || passwordText.getText().toString().equals("")
                        || passwordText.getText().toString().isEmpty())
                    break;

                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
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

    @Override
    public void onResultReceived(String response, String tag_json_obj) {
        if(tag_json_obj.equals(CHECK_EMAIL)){
            try {
                JSONObject jsonObject = new JSONObject(response);
                Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
                if (jsonObject.getBoolean("status")) {
                    String result = jsonObject.getString("message");
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }else{
                }
            }catch (Exception e){

            }
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
