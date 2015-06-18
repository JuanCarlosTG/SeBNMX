package com.appvisiondesigner.sbnmx;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


public class SectionActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_section);

        /*Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        if (Build.VERSION.SDK_INT<19){
            FrameLayout statusBar = (FrameLayout) findViewById(R.id.status_bar);
            statusBar.setVisibility(View.GONE);
        }

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i = new Intent(SectionActivity.this, KCOLogin.class);
                    startActivity(i);
                }
            }
        };
        timerThread.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
