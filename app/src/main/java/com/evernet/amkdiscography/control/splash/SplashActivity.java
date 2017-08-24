package com.evernet.amkdiscography.control.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.BuildConfig;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.amitshekhar.DebugDB;
import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.app.flow.ScreenManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private final int REQUEST_PERMISSION_CODE = 1;
    final Runnable delayedNavigation = new Runnable() {
        @Override
        public void run() {
            SplashActivity.this.navigate();
        }
    };
    Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_splash);

        if (BuildConfig.DEBUG)
            DebugDB.getAddressLog();

        if (!checkPlayServices()) {
            return;
        }

        List<String> permissions = new ArrayList<>();
        checkForPermission(permissions, Manifest.permission.ACCESS_FINE_LOCATION);
        checkForPermission(permissions, Manifest.permission.READ_PHONE_STATE);
        checkForPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        checkForPermission(permissions, Manifest.permission.CAMERA);
        checkForPermission(permissions, Manifest.permission.READ_CONTACTS);
        checkForPermission(permissions, Manifest.permission.CALL_PHONE);
        checkForPermission(permissions, Manifest.permission.RECEIVE_SMS);
        if (permissions.size() > 0) {
            ActivityCompat.requestPermissions(this, permissions.toArray(new String[permissions.size()]), REQUEST_PERMISSION_CODE);
        } else
            resumeNormalFlow();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            resumeNormalFlow();
        }
    }

    private void resumeNormalFlow() {

        //    navigate();
        //    return;


        handler = new Handler();
        handler.postDelayed(delayedNavigation, 2000);
    }

    @Override
    public void onBackPressed() {
        if (handler != null && delayedNavigation != null)
            handler.removeCallbacks(delayedNavigation);
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }


    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                finish();
            }
            return false;
        }
        return true;
    }

    public void onSendDeviceInfo() {
    }

    void navigate() {
        onSendDeviceInfo();
        boolean isLogin = false;
        if (isLogin) ScreenManager.getInstance().showStoreActivity(SplashActivity.this);
        else ScreenManager.getInstance().showLoginActivity(SplashActivity.this);
    }


    private void checkForPermission(List<String> permissions, String permission) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED)
            permissions.add(permission);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
