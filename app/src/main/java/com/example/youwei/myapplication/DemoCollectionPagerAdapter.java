package com.example.youwei.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by YouWei on 2016/7/21.
 */
public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tab_title = {"Android", "Apple", "Windows"};
    private int[] tab_icon = {R.drawable.ic_android, R.drawable.ic_apple, R.drawable.ic_windows};
    private int[] tab_icon_on = {R.drawable.ic_android_on, R.drawable.ic_apple_on, R.drawable.ic_windows_on};

    public DemoCollectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        args.putInt(DemoObjectFragment.ARG_OBJECT, position+1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return tab_title.length;
    }

    public int getIcon(int position) {
        return tab_icon[position];
    }

    public int getIcon_on(int position) {
        return tab_icon_on[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_title[position];
    }
}
