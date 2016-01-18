package com.example.hungry.task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Hungry on 1/17/2016.
 */
public class ShowTabPagesAdaptor extends FragmentPagerAdapter {
   String pageTitle[]={"Home","Category"};
    public ShowTabPagesAdaptor(FragmentManager supportFragmentManager, HomeAcitivity homeAcitivity) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new HomeFragment();
        }
        if (position==1){
            return new CategoryFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
