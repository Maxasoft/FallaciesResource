
package com.maxasoft.fallaciesresource;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
// import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FallaciesList extends ListActivity {

    private int iListID = 0;
    String[] ArrayList = null;
    String[] ArrayUrl = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            iListID = extras.getInt("ListId");
            switch (iListID) {
                case 0:
                    ArrayList = ListNizkor.ARRAY_FALLACIES;
                    ArrayUrl = ListNizkor.ARRAY_URL;
                    this.setTitle(this.getTitle() + " (Nizkor)");
                    break;
                case 1:
                    ArrayList = ListInfidels.ARRAY_FALLACIES;
                    ArrayUrl = ListInfidels.ARRAY_URL;
                    this.setTitle(this.getTitle() + " (SecularWeb)");
                    break;
                case 2:
                    ArrayList = ListFallacyFiles.ARRAY_FALLACIES;
                    ArrayUrl = ListFallacyFiles.ARRAY_URL;
                    this.setTitle(this.getTitle() + " (FallacyFiles)");
                    break;
                case 3:
                    ArrayList = ListYourLogicalFallacyIs.ARRAY_FALLACIES;
                    ArrayUrl = ListYourLogicalFallacyIs.ARRAY_URL;
                    this.setTitle(this.getTitle() + " (YourLogicalFallacyIs)");
                    break;
            }

            setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, ArrayList));

            ListView lv = getListView();
            lv.setTextFilterEnabled(true);

            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // When clicked, show a toast with the TextView text
                    Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                            Toast.LENGTH_SHORT).show();
                    if (ArrayUrl[position].contains(".html")) {
                        Intent i = new Intent(FallaciesList.this, FallacyText.class);
                        Bundle b = new Bundle();
                        b.putInt("ListId", iListID);
                        b.putInt("FallacyId", position);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            });
        }
    }

}