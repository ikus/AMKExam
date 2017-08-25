package com.evernet.amkdiscography.app.flow.utils;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.evernet.amkdiscography.AMKApplication;
import com.evernet.amkdiscography.R;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class WidgetUtils {
    private final String TAG = WidgetUtils.class.getSimpleName();
    private Toast mToast;
    public static WidgetUtils widgetUtils;

    private LoaderProgressDialog loaderProgressDialog;
    private Handler mHandler;

    public static WidgetUtils getInstance() {
        if (widgetUtils == null)
            widgetUtils = new WidgetUtils();
        return widgetUtils;
    }

    public WidgetUtils() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * Method that creates a short toast based in a String
     *
     * @param message The String that is going to be show
     */
    public void createShortToast(final String message) {
        mHandler.post(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(AMKApplication.getmContext(), message, Toast.LENGTH_SHORT);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a long Toast Message based in a string
     *
     * @param message The String that is going to be show
     */
    public void createLongToast(final String message) {
        mHandler.post(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(AMKApplication.getmContext(), message, Toast.LENGTH_LONG);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a short Toast based in a string id
     *
     * @param id The Int from the String id
     */
    public void createShortToast(final int id) {
        mHandler.post(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(AMKApplication.getmContext(), AMKApplication.getmContext().getString(id), Toast.LENGTH_SHORT);
                    mToast.show();
                }
            }
        });
    }

    /**
     * Method that creates a long Toast Message based in a string id
     *
     * @param id
     */
    public void createLongToast(final int id) {
        mHandler.post(new Runnable() {
            public void run() {
                if (!isToastShowing()) {
                    mToast = Toast.makeText(AMKApplication.getmContext(), AMKApplication.getmContext().getString(id), Toast.LENGTH_LONG);
                    mToast.show();
                }
            }
        });
    }

    private boolean isToastShowing() {
        if (mToast == null)
            return false;
        else if (mToast.getView().isShown())
            return true;
        else
            return false;
    }


    public void showSnackBar(final CoordinatorLayout rootLayout, String Message, int duration, Resources resources) {
        Snackbar snackbar = Snackbar
                .make(rootLayout, Message, duration);
        snackbar.getView().setBackgroundColor(ResourcesCompat.getColor(resources, R.color.colorPrimaryDark, null));
        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(5);
        snackbar.show();
    }

    public void showLoaderProgressDialog(final FragmentActivity context) {
        mHandler.post(new Runnable() {
            public void run() {
                clearLoaderProgressDialog();
                loaderProgressDialog = LoaderProgressDialog.newInstance(context);
                if (loaderProgressDialog != null)
                    loaderProgressDialog.show();
            }
        });
    }


    public void showLoaderProgressDialog(final FragmentActivity context, final String message) {
        mHandler.post(new Runnable() {
            public void run() {
                clearLoaderProgressDialog();
                loaderProgressDialog = LoaderProgressDialog.newInstance(context, message);
                if (loaderProgressDialog != null)
                    loaderProgressDialog.show();
            }
        });
    }


    public void clearLoaderProgressDialog() {
        if ((loaderProgressDialog != null) && loaderProgressDialog.isShowing()) {
            loaderProgressDialog.dismiss();
        }
        loaderProgressDialog = null;
    }


    public void hideLoaderProgressDialog() {
        mHandler.post(new Runnable() {
            public void run() {
                if (loaderProgressDialog != null && loaderProgressDialog.isShowing())
                    loaderProgressDialog.hide();
            }
        });
    }






}

