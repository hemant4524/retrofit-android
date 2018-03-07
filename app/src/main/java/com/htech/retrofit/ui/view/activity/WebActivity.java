package com.htech.retrofit.ui.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.htech.retrofit.R;

public class WebActivity extends AppCompatActivity {
    private static final String TAG = WebActivity.class.getSimpleName();
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mWebView = (WebView)findViewById(R.id.webview1);
//        getExtraValue();
    }

    private void getExtraValue() {
        String url = getIntent().getExtras().getString("URL");
        Log.d(TAG,"Url:"+url);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl(url);
    }
    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
