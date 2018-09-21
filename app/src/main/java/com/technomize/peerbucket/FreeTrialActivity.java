package com.technomize.peerbucket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by rishi on 9/20/2018.
 */

public class FreeTrialActivity extends AppCompatActivity implements View.OnClickListener {

    WebView mFreeTrialWebView;
    TextView mStartFreeTrial;
    ImageView mCloseFreeTrial;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_trial);

        mFreeTrialWebView=(WebView)findViewById(R.id.free_trial_webview);
        mStartFreeTrial=(TextView)findViewById(R.id.start_free_trial_tv);
        mCloseFreeTrial=(ImageView)findViewById(R.id.close_free_trial_iv);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mFreeTrialWebView.loadUrl("http://peerbuckets.tk/");

        mStartFreeTrial.setOnClickListener(this);
        mCloseFreeTrial.setOnClickListener(this);

        mFreeTrialWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap facIcon) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

        });

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
