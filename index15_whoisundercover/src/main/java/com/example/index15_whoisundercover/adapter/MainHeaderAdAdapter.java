package com.example.index15_whoisundercover.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MainHeaderAdAdapter extends PagerAdapter {
    protected Context context;
    protected List<ImageView> images;

    public MainHeaderAdAdapter(Context context, List<ImageView> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return null!=images?images.size():0;
    }

    // 判断新的视图是否和当前的视图相同；
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }
}
