package sonder.carousel;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<OnBackPressListener> registeredFragments = new SparseArray();

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "tab1";
            case 1: return "tab2";
            case 2: return "tab3";
        }
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FragmentA();
            case 1: return new FragmentB();
            case 2: return new FragmentC();
        }
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        OnBackPressListener fragment = (OnBackPressListener) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public OnBackPressListener getRegisteredFragment(int currentItem) {
        return registeredFragments.get(currentItem);
    }
}
