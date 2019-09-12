package com.thetechnocafe.Room.bottomsheets.ViewModel;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.thetechnocafe.Room.bottomsheets.R;

public class ItemsViewHolder extends RecyclerView.ViewHolder
{
    public FloatingActionButton imageAvatar;
    public TextView textView_ItemName;
    public ItemsViewHolder(View v)
    {
        super(v);
        imageAvatar = v.findViewById(R.id.image_avatar);
        textView_ItemName = v.findViewById(R.id.textView_itemName);
    }
}
