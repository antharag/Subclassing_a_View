package com.example.agnanaku.subclassingaview;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        final MyTextView view = (MyTextView) findViewById(R.id.top_left);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.incrementAndUpdate();
                int mCount = complete("View 1");
                Log.i("Top Left View Pressed", "" + mCount);
            }
        });

        final MyTextView view1 = (MyTextView) findViewById(R.id.bottom_right);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.incrementAndUpdate();
                int mCount = complete("View 1");
                Log.i("Bottom Right View Pressed", "" + mCount);
            }
        });

        final MyTextView view2 = (MyTextView) findViewById(R.id.bottom_left);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view2.incrementAndUpdate();
                int mCount = complete("View 1");
                Log.i("Bottom Left View Pressed", "" + mCount);
            }
        });

        final MyTextView view3 = (MyTextView) findViewById(R.id.top_right);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view3.incrementAndUpdate();
                int mCount = complete("View 1");
                Log.i("Top Right View Pressed", "" + mCount);
            }
        });
    }

    public int complete(String s) {
        SharedPreferences mSettings = MainActivity1.this.getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = mSettings.edit();
        int count = mSettings.getInt(s, 0);
        count++;
        editor.putInt(s, count).commit();
        return count;
    }

    public void reset(String s) {
        SharedPreferences mSettings = MainActivity1.this.getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(s, 0).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
