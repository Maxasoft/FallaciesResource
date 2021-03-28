package com.maxasoft.fallaciesresource;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FallaciesResource extends ListActivity {


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ly setContentView(R.layout.main);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, ARRAY_RESOURCES));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
          /*
       Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
          Toast.LENGTH_SHORT).show();
	       */
                Intent i;
                Bundle b;
                switch (position) {
                    case 0:
                        i = new Intent(FallaciesResource.this, Logical.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(FallaciesResource.this, FallaciesList.class);
                        b = new Bundle();
                        b.putInt("ListId", 0);
                        i.putExtras(b);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(FallaciesResource.this, FallaciesList.class);
                        b = new Bundle();
                        b.putInt("ListId", 1);
                        i.putExtras(b);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(FallaciesResource.this, FallaciesList.class);
                        b = new Bundle();
                        b.putInt("ListId", 2);
                        i.putExtras(b);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(FallaciesResource.this, FallaciesList.class);
                        b = new Bundle();
                        b.putInt("ListId", 3);
                        i.putExtras(b);
                        startActivity(i);
                        break;
                    case 5:
                        break;
                    case 6:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.theskepticsguide.org/resources/logical-fallacies"));
                        startActivity(i);
                        break;
                    case 7:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://austhink.com/critical"));
                        startActivity(i);
                        break;
                    case 8:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://herebedragonsmovie.com/"));
                        startActivity(i);
                        break;
                    case 9:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/List_of_fallacies"));
                        startActivity(i);
                        break;
                    case 10:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.logicalfallacies.info/"));
                        startActivity(i);
                        break;
                    case 11:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.onegoodmove.org/fallacy/toc.htm"));
                        startActivity(i);
                        break;
                    case 12:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nizkor.org/features/fallacies/"));
                        startActivity(i);
                        break;
                    case 13:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.infidels.org/library/modern/mathew/logic.html"));
                        startActivity(i);
                        break;
                    case 14:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fallacyfiles.org"));
                        startActivity(i);
                        break;
                    case 15:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yourlogicalfallacyis.com"));
                        startActivity(i);
                        break;
                    case 16:
                        i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.logicallyfallacious.com"));
                        startActivity(i);
                        break;
                    case 17:
                        break;
                    case 18:
                        i = new Intent(FallaciesResource.this, About.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }

  /* @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
  } */

    static final String[] ARRAY_RESOURCES = new String[]{
  	/* 00 */ "Constructing a Logical Argument (offline)",
  	/* 01 */ "Fallacies - Nizkor (offline)",
  	/* 02 */ "Logic & Fallacies - Secular Web (offline)",
  	/* 03 */ "Fallacies - Fallacy Files (offline)",
    /* 04 */ "Your Logical Fallacy Is (offline)",
  	/* 05 */ "",
  	/* 06 */ "The Skeptic's Guide to the Universe - Introduction to Argument (online website)",
  	/* 07 */ "Critical Thinking On The Web (directory of quality online resources)",
  	/* 08 */ "Introduction to Critical Thinking (online video)",
  	/* 09 */ "List of Fallacies - Wikipedia (online website)",
  	/* 10 */ "Logical Fallacies (online website)",
  	/* 11 */ "Stephen's Guide to Fallacies (online website)",
  	/* 12 */ "Fallacies - Nizkor.org (online website)",
  	/* 13 */ "Logic & Fallacies - Secular Web (online website)",
  	/* 14 */ "Fallacy Files (online website)",
    /* 15 */ "Your Logical Fallacy Is (online website)",
    /* 16 */ "Logically Fallacious (online website)",
    /* 17 */ "",
  	/* 18 */ "About",
    };

}