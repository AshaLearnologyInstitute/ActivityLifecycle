package com.activitylifecycle.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.activitylifecycle.R;
import com.activitylifecycle.model.Item;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemListViewHolder> {

    private ArrayList<Item> items;
    private OnItemClickListener itemClickListener;


    public ItemAdapter(ArrayList<Item> items) {
        this.items=items;
    }

    public ItemAdapter(ArrayList<Item> items,OnItemClickListener itemClickListener) {
        this.items=items;
        this.itemClickListener=itemClickListener;
    }


    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final Context context = parent.getContext();
        final LayoutInflater layoutInflater = LayoutInflater.from(context);

        final View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ItemListViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        Item item = items.get(position);
        if(position%2==0) {
            holder.name.setText(item.getItem_name());
            holder.price.setText(item.getPrice() + "");
            holder.quantity.setText(item.getQuantity() + "");

            holder.name.setVisibility(View.INVISIBLE);
            holder.price.setVisibility(View.VISIBLE);

            holder.itemView.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_LONG).show();
                items.get(position).setQuantity(item.getQuantity() + 1);
                itemClickListener.onClicked(item);
            });
            holder.itemImage.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "Image clicked", Toast.LENGTH_LONG).show();
            });
        }else {
            holder.name.setText(item.getItem_name());
            holder.price.setText(item.getPrice() + "");
            holder.quantity.setText(item.getQuantity() + "");

            holder.name.setVisibility(View.VISIBLE);
            holder.price.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemListViewHolder extends RecyclerView.ViewHolder{
        private TextView name, price, quantity;
        private ImageView itemImage;

        public ItemListViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            quantity = itemView.findViewById(R.id.tv_quantity);
            itemImage= itemView.findViewById(R.id.item_img);
        }
    }

    public interface OnItemClickListener{
        void onClicked(Item item);
    }
}

//https://www.kasandbox.org/programming-images/avatars/marcimus-red.png