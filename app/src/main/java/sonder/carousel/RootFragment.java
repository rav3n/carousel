package sonder.carousel;

import android.support.v4.app.Fragment;

public class RootFragment extends Fragment implements OnBackPressListener {
    @Override
    public boolean onBackPressed() {
        return new SimpleBackPress(this).onBackPressed();
    }

    protected int current() {
        if (getArguments() == null) return 0;
        return getArguments().getInt("index",0);
    }
}
