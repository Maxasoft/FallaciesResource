package com.maxasoft.fallaciesresource;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class FallacyText extends Activity {

    private WebView wv;

    private float x1, x2;
    private float y1, y2;
    static final int MIN_DISTANCE = 50;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int iList = extras.getInt("ListId");
            String[] UrlList = null;
            String strPath = "";
            switch (iList) {
                case 0:
                    UrlList = ListNizkor.ARRAY_URL;
                    strPath = "Nizkor";
                    this.setTitle(this.getTitle() + " (Nizkor)");
                    break;
                case 1:
                    UrlList = ListInfidels.ARRAY_URL;
                    strPath = "Infidels";
                    this.setTitle(this.getTitle() + " (SecularWeb)");
                    break;
                case 2:
                    UrlList = ListFallacyFiles.ARRAY_URL;
                    strPath = "FallacyFiles";
                    this.setTitle(this.getTitle() + " (FallacyFiles)");
                    break;
                case 3:
                    UrlList = ListYourLogicalFallacyIs.ARRAY_URL;
                    strPath = "YourLogicalFallacyIs";
                    this.setTitle(this.getTitle() + " (YourLogicalFallacyIs)");
                    break;
                case 4:
                    UrlList = ListYourLogicalFallacyIs.ARRAY_URL;
                    strPath = "YourLogicalFallacyIs";
                    this.setTitle(this.getTitle() + " (YourLogicalFallacyIs)");
                    break;
            }
            int iFallacy = extras.getInt("FallacyId");
            if (iFallacy < UrlList.length) {
                String strUrl = UrlList[iFallacy];
                if (strUrl != "") {
                    wv = (WebView)findViewById(R.id.web);
                    wv.loadUrl("file:///android_asset/" + strPath + "/" + strUrl);
                }
            }
        }

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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;
                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (x1 < x2) {
                        Toast.makeText(this, "Left to Right Swipe Performed", Toast.LENGTH_SHORT).show();
                        Log.i("action", "Left to Right Swipe Performed");
                    } else if (x1 > x2) {
                        Toast.makeText(this, "Right to Left Swipe Performed", Toast.LENGTH_SHORT).show();
                        Log.i("action", "Right to Left Swipe Performed");
                    }
                } else {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }

}