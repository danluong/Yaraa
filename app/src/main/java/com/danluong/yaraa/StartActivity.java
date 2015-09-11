package com.danluong.yaraa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.danluong.yaraa.views.ArticleListActivity;
import com.danluong.yaraa.views.IntroActivity;


public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // show IntroActivity only on first launch
        switchActivity();
    }

    void switchActivity(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);

        boolean firstRun = settings.getBoolean("firstRun", true);
        Intent intent;
        if ( firstRun )
        {
            intent = new Intent(this, IntroActivity.class);
        } else {
            intent = new Intent(this, ArticleListActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
