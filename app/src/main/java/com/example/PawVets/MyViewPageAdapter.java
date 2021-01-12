package com.example.PawVets;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class MyViewPageAdapter extends FragmentPagerAdapter {
    public MyViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
