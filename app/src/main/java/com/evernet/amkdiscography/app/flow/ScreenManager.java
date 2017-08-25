package com.evernet.amkdiscography.app.flow;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.control.loggin.LoginActivity;
import com.evernet.amkdiscography.control.store.ui.StoreActivity;
import com.evernet.amkdiscography.control.store.ui.fragment.FirstFilterFragment;
import com.evernet.amkdiscography.control.store.ui.fragment.SecondFilterFragment;
import com.evernet.amkdiscography.control.store.ui.model.CategoryModel;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class ScreenManager {


    public static synchronized ScreenManager getInstance() {
        return new ScreenManager();
    }



    public void showStoreActivity(FragmentActivity origin) {
        Intent intent = new Intent(origin, StoreActivity.class);
        intent.setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        origin.startActivity(intent);
    }

    public void showLoginActivity(FragmentActivity origin) {
        Intent intent = new Intent(origin, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        origin.startActivity(intent);
    }

    public void showFirstFilter(FragmentActivity fragmentactivity) {
        FirstFilterFragment fragmentFirstFilter = FirstFilterFragment.newInstance();
        fragmentactivity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentactivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragmentFirstFilter)
                .commit();
    }

    public void showSecondFilter(FragmentActivity fragmentactivity, CategoryModel categoryModel) {
        SecondFilterFragment fragment = SecondFilterFragment.newInstance(categoryModel);
        fragmentactivity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentactivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}

