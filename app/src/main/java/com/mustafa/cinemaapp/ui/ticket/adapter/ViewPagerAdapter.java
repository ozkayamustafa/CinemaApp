package com.mustafa.cinemaapp.ui.ticket.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mustafa.cinemaapp.ui.ticket.fragments.cinema.CinemaFragment;
import com.mustafa.cinemaapp.ui.ticket.fragments.concert.ConcertFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = CinemaFragment.newInstance();
                break;
            case 1:
                fragment = ConcertFragment.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence sequence;
        switch (position){
            case 0:
                sequence  = "Cinema";
                break;
            case 1:
                sequence = "Concert";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return sequence;
    }
}
