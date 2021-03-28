package com.maxasoft.fallaciesresource;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Logical extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        WebView wv = (WebView) findViewById(R.id.web);
        wv.loadUrl("file:///android_asset/ConstructingALogicalArgument.html");
        // String htmlData = "<link rel=\"stylesheet\" type=\"text/css\" href=\"style-light.css\" />";
        // wv.loadDataWithBaseURL("file:///android_asset/ConstructingALogicalArgument.html", htmlData, "text/html", "UTF-8", null);
        // wv.loadUrl("file:///android_asset/ConstructingALogicalArgument.html");
    }

}