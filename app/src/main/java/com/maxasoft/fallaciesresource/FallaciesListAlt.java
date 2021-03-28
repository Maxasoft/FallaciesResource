package com.maxasoft.fallaciesresource;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public class FallaciesListAlt extends Activity {

    private WebView wv;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        wv = (WebView) findViewById(R.id.web);
        wv.loadUrl("file:///android_asset/Nizkor/ListNizkor.html");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (wv.canGoBack() == true) {
                        wv.goBack();
                    } else {
                        finish();
                    }
                    return (true);
            }
        }
        return (super.onKeyDown(keyCode, event));
    }

}