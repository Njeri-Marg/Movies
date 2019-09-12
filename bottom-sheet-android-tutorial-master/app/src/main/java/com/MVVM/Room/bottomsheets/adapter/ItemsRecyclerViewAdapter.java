package com.thetechnocafe.Room.bottomsheets.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thetechnocafe.Room.bottomsheets.model.ItemsEntity;
import com.thetechnocafe.Room.bottomsheets.R;
import com.thetechnocafe.Room.bottomsheets.ViewModel.ItemsViewHolder;


import java.util.List;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsViewHolder> {
    private List<ItemsEntity> itemsMapList;
    private Context context;

    public ItemsRecyclerViewAdapter(List<ItemsEntity> itemList, Context context)
    {
        this.itemsMapList = itemList;
        this.context = context;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.single_bottomsheet_view, parent, false);

        // Inflate the layout
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {

        final ItemsEntity itemsMap = itemsMapList.get(position);

        Picasso.with(context).load(itemsMap.getImageUrl()).fit().into(holder.imageAvatar);
        holder.textView_ItemName.setText(itemsMap.getIconTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item Clicked: " + itemsMap.getIconTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemsMapList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
