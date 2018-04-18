package com.selflearning.amansrivastav.instaclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.selflearning.amansrivastav.instaclone.R;

/**
 * Created by Aman.Srivastav on 18-04-2018.
 */

public class SignoutFragment extends Fragment {
    private static final String TAG = "SignoutFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
       return view;
    }
}
