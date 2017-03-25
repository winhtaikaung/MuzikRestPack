package com.win.muzikrestpack.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.win.muzikrestpack.R;

import butterknife.ButterKnife;

/**
 * Created by win on 3/25/17.
 */

public class SongListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songlist,container,false);
        ButterKnife.bind(this,view);

        return view;
    }
}
