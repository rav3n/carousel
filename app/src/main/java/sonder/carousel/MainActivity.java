package sonder.carousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private CarouselFragment carouselFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            initFragment();
        } else {
            carouselFragment = (CarouselFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initFragment() {
        carouselFragment = new CarouselFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, carouselFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (!carouselFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
