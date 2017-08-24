package com.evernet.amkdiscography.control.store.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.app.flow.ScreenManager;

import butterknife.ButterKnife;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class StoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setTheme(R.style.MaterialTheme); // for Custom theme)
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScreenManager.getInstance().showFirstFilter(StoreActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                //ScreenManager.showSettingsScreen(this);
                Toast.makeText(this, "Bye", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
