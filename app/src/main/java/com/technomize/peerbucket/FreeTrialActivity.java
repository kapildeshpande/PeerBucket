package com.technomize.peerbucket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rishi on 9/20/2018.
 */

public class FreeTrialActivity extends AppCompatActivity implements View.OnClickListener {

    WebView mFreeTrialWebView;
    TextView mStartFreeTrial;
    ImageView mCloseFreeTrial;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_trial);

        mFreeTrialWebView=(WebView)findViewById(R.id.free_trial_webview);
        mStartFreeTrial=(TextView)findViewById(R.id.start_free_trial_tv);
        mCloseFreeTrial=(ImageView)findViewById(R.id.close_free_trial_iv);

        mFreeTrialWebView.loadUrl("http://peerbuckets.tk/");

        mStartFreeTrial.setOnClickListener(this);
        mCloseFreeTrial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_free_trial_tv:
                Intent su_intent=new Intent(this,SignUpActivity.class);
                startActivity(su_intent);
                break;
            case R.id.close_free_trial_iv:
                finish();
                break;
        }
    }
}
