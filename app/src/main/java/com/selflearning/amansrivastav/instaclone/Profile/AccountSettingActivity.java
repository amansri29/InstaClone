package com.selflearning.amansrivastav.instaclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.selflearning.amansrivastav.instaclone.R;

/**
 * Created by Aman.Srivastav on 18-04-2018.
 */

public class AccountSettingActivity extends AppCompatActivity{
    private static final String TAG = "AccountSettingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        Log.d(TAG, "onCreate: started");
    }
}
