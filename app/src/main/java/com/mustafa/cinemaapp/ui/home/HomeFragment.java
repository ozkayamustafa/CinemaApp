package com.mustafa.cinemaapp.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mustafa.cinemaapp.R;
import com.mustafa.cinemaapp.adapters.ViewPagerAdapter;
import com.mustafa.cinemaapp.data.imageData.ImageData;
import com.mustafa.cinemaapp.viewpagerAnim.CubeInScalingAnimation;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private ViewPagerAdapter adapter;
    RecyclerView viewPager;
    List<Bitmap> bitmapList = new ArrayList<Bitmap>();

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        // adapter = new ViewPagerAdapter(ImageData.bitmapList);
       // viewPager.setAdapter(adapter);
       // viewPager.setPageTransformer(new CubeInScalingAnimation());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap movie1 = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.movie1);
        Bitmap movie2 = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.movie2);
        Bitmap movie3 = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.movie3);
        Bitmap movie4 = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.movie4);
        Bitmap movie5 = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.movie5);
        bitmapList.add(movie1);
        bitmapList.add(movie2);
        bitmapList.add(movie3);
        bitmapList.add(movie4);
        bitmapList.add(movie5);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager);

        adapter = new ViewPagerAdapter(bitmapList);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        viewPager.setLayoutManager(layoutManager);
        viewPager.setAdapter(adapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(viewPager);


    }

}