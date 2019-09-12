package ke.co.mariashops.myroommvvm.adapters;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import ke.co.mariashops.myroommvvm.ItemsEntity;
import ke.co.mariashops.myroommvvm.R;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemHolder>{

    private List<ItemsEntity> itemsEntities=new ArrayList<>();
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View itemView = LayoutInflater.from(parent.getContext())
             .inflate(R.layout.activity_main,parent,false);
        return new ItemHolder(itemView) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final ItemsEntity currentItemEntity=itemsEntities.get(position);
        Picasso.with(Context ).load(currentItemEntity.getImageUrl()).fit().into(holder.floatingActionButton);
        holder.textViewItemName.setText(currentItemEntity.getIconTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Context, "Item Clicked: " + currentItemEntity.getIconTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsEntities.size();
    }
    public void setItemsEntity(List<ItemsEntity>itemsEntity){
        this.itemsEntities = itemsEntity;
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        private FloatingActionButton floatingActionButton;
        private TextView textViewItemName;

        public ItemHolder(View itemView) {
            super(itemView);
            floatingActionButton= itemView.findViewById(R.id.image_avatar);
            textViewItemName= itemView.findViewById(R.id.textView_itemName);
        }
    }

}
