package sonder.carousel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends RootFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_root, container, false);
        TextView tv = view.findViewById(R.id.label);
        tv.setBackgroundColor(Color.RED);
        tv.setText("Fragment A: " + current());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextFragment();
            }
        });
        return view;
    }

    public void nextFragment() {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragment_main_container, FragmentA.start(current() + 1)).commit();
    }

    public static Fragment start(int index) {
        FragmentA fragmemnt = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragmemnt.setArguments(bundle);
        return fragmemnt;
    }

}
