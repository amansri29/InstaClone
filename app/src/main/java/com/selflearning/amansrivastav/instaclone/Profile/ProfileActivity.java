package com.selflearning.amansrivastav.instaclone.Profile;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.selflearning.amansrivastav.instaclone.R;
import com.selflearning.amansrivastav.instaclone.utils.BottomNavigationViewHelper;
import com.selflearning.amansrivastav.instaclone.utils.GridImageAdapter;
import com.selflearning.amansrivastav.instaclone.utils.UniversalImageLoader;

import java.util.ArrayList;

/**
 * Created by Aman.Srivastav on 05-04-2018.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private ProgressBar progressBar;
//    private final int NUM_GRID_COLUMN = 3;
    ImageView profileImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        progressBar = (ProgressBar) findViewById(R.id.profile_progressbar);
        progressBar.setVisibility(View.GONE);
        setupBottomNavigationView();
        profileImage = (ImageView) findViewById(R.id.profile_photo);
        Log.d(TAG, "onCreate: started");
        setupToolbar();
        setProfilePhoto();
        tempGridSetup();
    }

    private void setProfilePhoto()
    {
        String imageUrl = "https://static.pexels.com/photos/5854/sea-woman-legs-water-medium.jpg";
        UniversalImageLoader.setImage(imageUrl, profileImage, null, "");
    }


    private void setupToolbar()
    {
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        
//        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Log.d(TAG, "onMenuItemClick: clicked menu item : " + item);
//                switch (item.getItemId()) {
//                    case R.id.profileMenu:
//                        Log.d(TAG, "onMenuItemClick: Navigating to profile refrences");
//                }
//                return false;
//            }
//        });


        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupBottomNavigationView()
    {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this, bottomNavigationViewEx);


        // for highlighting the menu item selected
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }


    private void tempGridSetup()
    {
        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://static.pexels.com/photos/5968/wood-nature-dark-forest-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6101/hands-woman-art-hand-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6740/food-sugar-lighting-milk-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/5659/sky-sunset-clouds-field-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6945/sunset-summer-golden-hour-paul-filitchkin-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/6151/animal-cute-fur-white-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/5696/coffee-cup-water-glass-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/6789/flowers-petals-gift-flower-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/7202/summer-trees-sunlight-trail-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/7147/night-clouds-summer-trees-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6342/woman-notebook-working-girl-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/7147/night-clouds-summer-trees-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6292/blue-pattern-texture-macro-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/6946/summer-bicycle-letsride-paul-filitchkin-medium.jpg");
        imageUrls.add("https://static.pexels.com/photos/6923/mountains-fog-green-beauty-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/7045/pexels-photo-medium.jpeg");
        imageUrls.add("https://static.pexels.com/photos/6872/cold-snow-nature-weather-medium.jpg");
        imageUrls.add( "https://static.pexels.com/photos/5998/sky-love-people-romantic-medium.jpg");
        setupImageGrid(imageUrls);

    }

    void  setupImageGrid(ArrayList<String> imageUrls)
    {
//        int gridWidth = getResources().getDisplayMetrics().widthPixels;
//        int imageWidth = gridWidth / NUM_GRID_COLUMN;

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        GridImageAdapter gridImageAdapter = new GridImageAdapter(this, R.layout.layout_grid_imageview, "",imageUrls);
        gridView.setAdapter(gridImageAdapter);
    }
}
