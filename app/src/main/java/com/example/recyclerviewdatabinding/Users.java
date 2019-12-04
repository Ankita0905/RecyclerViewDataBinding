package com.example.recyclerviewdatabinding;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users
{
    public String name,email;
    public int imageId;

    public Users(String name, String email, int imageId)
    {
        this.name = name;
        this.email = email;
        this.imageId = imageId;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImages(View view,int imageId)
    {
        CircleImageView circleImageView= (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));

    }
}
