package com.example.halfm_1.tabbedview;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Locale;

/**
 * Created by HalFM-1 on 10/8/2015.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

public FragmentAdapter(android.support.v4.app.FragmentManager fm){
    super(fm);

}
    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                tab1 t1 = new tab1();
                return t1;
            case 1:
                tab2 t2 = new tab2();
                return t2;
            case 2:
                tab3 t3 = new tab3();
                return t3;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }//set the number of tabs

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Contacts";
            case 1:

                return "About";
            case 2:

                return "Support";
        }
        return null;
    }


}
