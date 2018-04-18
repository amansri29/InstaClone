package com.selflearning.amansrivastav.instaclone.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.selflearning.amansrivastav.instaclone.Home.HomeActivity;
import com.selflearning.amansrivastav.instaclone.Likes.LikeActivity;
import com.selflearning.amansrivastav.instaclone.Profile.ProfileActivity;
import com.selflearning.amansrivastav.instaclone.R;
import com.selflearning.amansrivastav.instaclone.Search.SearchActivity;
import com.selflearning.amansrivastav.instaclone.Share.ShareActivity;

/**
 * Created by Aman.Srivastav on 05-04-2018.
 */

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        Log.d(TAG, "setupBottomNavigationView: Setting up Bottom Navigation");
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                                                     @Override
                                                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                         switch (item.getItemId())
                                                         {
                                                             case R.id.ic_house:
                                                                 Intent intent1 = new Intent(context, HomeActivity.class);
                                                                 context.startActivity(intent1);
                                                                 break;
                                                             case R.id.ic_search:
                                                                 Intent intent2 = new Intent(context, SearchActivity.class);
                                                                 context.startActivity(intent2);
                                                                 break;
                                                             case R.id.ic_circle:
                                                                 Intent intent3 = new Intent(context, ShareActivity.class);
                                                                 context.startActivity(intent3);
                                                                 break;
                                                             case R.id.ic_alert:
                                                                 Intent intent4 = new Intent(context, LikeActivity.class);
                                                                 context.startActivity(intent4);
                                                                 break;
                                                             case R.id.ic_android:
                                                                 Intent intent5 = new Intent(context, ProfileActivity.class);
                                                                 context.startActivity(intent5);
                                                                 break;
                                                         }
                                                         return false;
                                                     }
                                                 }
        );
    }
}
