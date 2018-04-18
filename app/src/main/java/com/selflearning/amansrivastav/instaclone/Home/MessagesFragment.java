package com.selflearning.amansrivastav.instaclone.Home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.selflearning.amansrivastav.instaclone.R;

/**
 * Created by Aman.Srivastav on 09-04-2018.
 */

public class MessagesFragment extends android.support.v4.app.Fragment{
    private static final String TAG = "MessagesFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        return view;
    }
}
