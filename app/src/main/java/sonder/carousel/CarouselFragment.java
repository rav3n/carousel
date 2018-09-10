package sonder.carousel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CarouselFragment extends Fragment {

    private SimpleFragmentPagerAdapter adapter;
    private FragmentViewPager pager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new SimpleFragmentPagerAdapter(getChildFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.carousel_fragment, container, false);
        pager = view.findViewById(R.id.view_pager);
        pager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

    public boolean onBackPressed() {
        OnBackPressListener currentFragment = adapter
                .getRegisteredFragment(pager.getCurrentItem());
        if (currentFragment != null) {
            return currentFragment.onBackPressed();
        }
        return false;
    }

}
