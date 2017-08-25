package com.evernet.amkdiscography.control.loggin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.app.flow.ScreenManager;
import com.evernet.amkdiscography.app.flow.utils.Const;
import com.evernet.amkdiscography.app.flow.utils.SharedPreferencesUtil;
import com.evernet.amkdiscography.app.flow.utils.WidgetUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.loginButton)
    public void onClickLogin()  {
        if (validateLogin()) {
            WidgetUtils.getInstance().showLoaderProgressDialog(LoginActivity.this);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WidgetUtils.getInstance().clearLoaderProgressDialog();
            ScreenManager.getInstance().showStoreActivity(LoginActivity.this);
        }
    }

    private boolean validateLogin() {
        if (!SharedPreferencesUtil.getBoolean(Const.IS_LOGGED)) {
            SharedPreferencesUtil.setAppPreference(Const.IS_LOGGED, true);
            return true;
        }
        return false;
    }
}
