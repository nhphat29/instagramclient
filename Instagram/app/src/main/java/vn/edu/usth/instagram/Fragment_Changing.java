package vn.edu.usth.instagram;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Fragment_Changing extends FragmentStateAdapter {

    public Fragment_Changing(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Home();
            case 1:
                return new Search();
            case 2:
                return new Profile();
            default:
                return new Home();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}