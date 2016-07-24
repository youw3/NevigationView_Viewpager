package com.example.youwei.myapplication;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.color.CircleView;


public class SettingsActivity extends AppCompatActivity  {

    Toolbar settings_toolbar;
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settings_toolbar = (Toolbar) findViewById(R.id.settings_toolbar);
        setSupportActionBar(settings_toolbar);
        settings_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if(getSharedPreferences("config", MODE_PRIVATE).getInt("themeColor", R.color.colorPrimary)!=R.color.colorPrimary) {
            SharedPreferences pref = getSharedPreferences("config", MODE_PRIVATE);
            int themeColor = pref.getInt("themeColor", 0);
            initThemeColor(themeColor);
        }

        //getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }


    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState)  {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    private void initThemeColor(int color) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(CircleView.shiftColorDown(color));
        }*/
        settings_toolbar.setBackgroundColor(color);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(CircleView.shiftColorDown(color));
        }
    }

}
