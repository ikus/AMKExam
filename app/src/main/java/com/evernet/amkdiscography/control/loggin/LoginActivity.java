package com.evernet.amkdiscography.control.loggin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.app.flow.ScreenManager;
import com.evernet.amkdiscography.app.flow.utils.Const;
import com.evernet.amkdiscography.app.flow.utils.SharedPreferencesUtil;
import com.evernet.amkdiscography.app.flow.utils.WidgetUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.editTextUser)
    AppCompatEditText editTextUser;
    @Bind(R.id.editTextPassword)
    AppCompatEditText editTextPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.loginButton)
    public void onClickLogin() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                WidgetUtils.getInstance().showLoaderProgressDialog(LoginActivity.this);
                return;
            }

            @Override
            protected void onPostExecute(Void result) {
                WidgetUtils.getInstance().clearLoaderProgressDialog();
                return;
            }

            @Override
            protected Void doInBackground(Void... voids) {
                if (validateLogin()) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ScreenManager.getInstance().showStoreActivity(LoginActivity.this);
                } else WidgetUtils.getInstance().createShortToast("Verifica tu informacion.");
                return null;
            }
        }.execute();


    }

    private boolean validateLogin() {
        if (editTextUser.getText().toString().trim().equals("") && editTextPassword.getText().toString().trim().equals(""))
            return false;
        if (editTextUser.getText().toString().trim().contains(" ") || editTextPassword.getText().toString().trim().contains(" "))
            return false;
        if (!PasswordValidator.getInstance().validate(editTextPassword.getText().toString()))
            return false;
        if (!editTextUser.getText().toString().equals("Usuario1"))
            return false;

        SharedPreferencesUtil.setAppPreference(Const.IS_LOGGED, true);
        return true;


    }
}
