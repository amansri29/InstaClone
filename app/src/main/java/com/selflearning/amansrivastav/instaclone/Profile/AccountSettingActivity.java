package com.selflearning.amansrivastav.instaclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.selflearning.amansrivastav.instaclone.Home.HomeActivity;
import com.selflearning.amansrivastav.instaclone.R;
import com.selflearning.amansrivastav.instaclone.utils.BottomNavigationViewHelper;
import com.selflearning.amansrivastav.instaclone.utils.SectionStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Aman.Srivastav on 18-04-2018.
 */

public class AccountSettingActivity extends AppCompatActivity{
    private static final String TAG = "AccountSettingActivity";
    private static final int ACTIVITY_NUM = 4;
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        Log.d(TAG, "onCreate: started");
        viewPager = (ViewPager) findViewById(R.id.container);
        relativeLayout = (RelativeLayout) findViewById(R.id.relLayout1);
        setupSettingList();
        setupFragment();
        setupBottomNavigationView();
        ImageView backButton = (ImageView) findViewById(R.id.backArrow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: going back to profile");
                finish();
            }
        });

    }

    private  void setViewPager(int fragmentNumber)
    {
        relativeLayout.setVisibility(View.GONE);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }
    void setupFragment()
    {
        pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));   // fragment 0
        pagerAdapter.addFragment(new SignoutFragment(), getString(R.string.sign_out));            // fragment 1
    }


    void setupSettingList()
    {
        Log.d(TAG, "setupSettingList: intialzing");
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: navigate fragment no " + i);   // i is item position
                setViewPager(i);
            }
        });
    }



    private void setupBottomNavigationView()
    {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(AccountSettingActivity.this, bottomNavigationViewEx);

        // for highlighting the menu item selected
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
