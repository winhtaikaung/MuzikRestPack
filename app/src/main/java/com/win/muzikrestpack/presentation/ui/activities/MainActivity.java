package com.win.muzikrestpack.presentation.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.win.muzikrestpack.R;
import com.win.muzikrestpack.presentation.ui.fragments.ArtistListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final String[] titles = {"Songs", "Artists"};
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.viewContainer)
    FrameLayout mViewContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            ArtistListFragment fragment = new ArtistListFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(mViewContainer.getId(), fragment).commit();
        }


    }


}
