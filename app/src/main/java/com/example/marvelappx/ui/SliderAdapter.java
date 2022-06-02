package com.example.marvelappx.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.marvelappx.R;

public class SliderAdapter extends PagerAdapter {

Context context;
LayoutInflater layoutInflater;

public SliderAdapter(Context context){
    this.context = context;
}

//Arrays
    public int[] slide_images = {
        R.drawable.civilwar1,
        R.drawable.civilwar2,
};

public String[] slide_headings = {
        "primeiro",
        "segundo"
};
    public String[] slide_descs = {
      "",
      ""
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView=(ImageView)view.findViewById(R.id.imageView2);
        TextView slideHeading=(TextView)view.findViewById(R.id.heading);
        TextView slidedescription=(TextView)view.findViewById(R.id.description);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slidedescription.setText(slide_descs[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object)
    {

        container.removeView((RelativeLayout)object);
    }
}
