package com.selflearning.amansrivastav.instaclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.selflearning.amansrivastav.instaclone.R;
import com.selflearning.amansrivastav.instaclone.utils.UniversalImageLoader;

/**
 * Created by Aman.Srivastav on 18-04-2018.
 */

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private ImageView profileImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
       profileImage = (ImageView)view.findViewById(R.id.profile_photo);

       setProfileImage();


       // going back to profile
        ImageView back = (ImageView) view.findViewById(R.id.backArrow);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

       return view;
    }




    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image");
        String imageUrl = "https://static.pexels.com/photos/5854/sea-woman-legs-water-medium.jpg";
        UniversalImageLoader.setImage(imageUrl, profileImage, null, "");
    }

}
