package com.evernet.amkdiscography;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class AMKApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mContext = getApplicationContext();
    }

    public static Context getmContext() {
        return mContext;
    }

}
