package com.maxasoft.fallaciesresource;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class About extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        WebView wv = (WebView) findViewById(R.id.web);
        this.setTitle(this.getTitle() + " - About");
        wv.loadUrl("file:///android_asset/About.html");
    }

}