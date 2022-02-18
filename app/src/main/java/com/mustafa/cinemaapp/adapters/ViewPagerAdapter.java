package com.mustafa.cinemaapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.cinemaapp.R;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ImageHelper> {

   List<Bitmap> bitmapList;

    public ViewPagerAdapter(List<Bitmap> bitmapList) {
        this.bitmapList = bitmapList;
    }

    @NonNull
    @Override
    public ImageHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rows_movie,parent,false);
        return new ImageHelper(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHelper holder, int position) {
            Bitmap bitmap = bitmapList.get(position);
         holder.moviewImage.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return bitmapList.size();
    }

    class  ImageHelper extends RecyclerView.ViewHolder{
         ImageView moviewImage;
        public ImageHelper(@NonNull View itemView) {
            super(itemView);
            moviewImage = itemView.findViewById(R.id.movieImage);
        }

    }

}
