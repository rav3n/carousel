package sonder.carousel;

public class SimpleBackPress implements OnBackPressListener {

    private RootFragment rootFragment;

    public SimpleBackPress(RootFragment rootFragment) {
        this.rootFragment = rootFragment;
    }

    @Override
    public boolean onBackPressed() {
        if (rootFragment == null) {
            return false;
        }

        int count = rootFragment.getChildFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            return false;
        }

        if (count > 0) {
            OnBackPressListener child = (OnBackPressListener) rootFragment.getChildFragmentManager().getFragments().get(0);
            if (!child.onBackPressed()) {
                rootFragment.getChildFragmentManager().popBackStackImmediate();
            }
        }
        return true;
    }
}
