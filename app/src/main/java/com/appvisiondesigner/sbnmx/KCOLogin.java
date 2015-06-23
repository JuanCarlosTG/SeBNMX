package com.appvisiondesigner.sbnmx;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;


public class KCOLogin extends ActionBarActivity {

    EditText etUser, etPassword;
    ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kcologin);

        if (Build.VERSION.SDK_INT<19){
            FrameLayout statusBar = (FrameLayout) findViewById(R.id.status_bar);
            statusBar.setVisibility(View.GONE);
        }

        etUser     = (EditText) findViewById(R.id.inp_soid);
        etPassword = (EditText) findViewById(R.id.inp_pass);
        btnLogin   = (ImageButton) findViewById(R.id.btnLogin);

        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/InterstateBold.ttf");

        etUser.setTypeface(myFont);
        etPassword.setTypeface(myFont);

    }

    public void forgotPassword(View v){
        Intent i = new Intent(KCOLogin.this, KCORecoverPassword.class);
        startActivity(i);
    }

    public void registerL(View v){
        Intent i = new Intent(KCOLogin.this, KCORegister.class);
        startActivity(i);
    }

    public void loginProblems(View v){
        Intent i = new Intent(KCOLogin.this, KCOLoginProblems.class);
        startActivity(i);
    }

    public void homeAction(View v){
        Intent i = new Intent(KCOLogin.this, KCOHome.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kcologin, menu);
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
