package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.activitylifecycle.adapter.ItemAdapter;
import com.activitylifecycle.model.Item;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView listRecyclerView;
    ItemAdapter listAdapter;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        listRecyclerView=findViewById(R.id.item_list);
        if(getIntent().hasExtra("ItemDetails")) {

//            items = getIntent().getParcelableArrayListExtra("ItemDetails");

            Bundle bundle = getIntent().getExtras();
            items = bundle.getParcelableArrayList("ItemDetails");

            Log.e("Data",items.toString());
        }

        /*ItemAdapter*/ listAdapter = new ItemAdapter(items,itemClickListener);
//        ItemAdapter listAdapter = new ItemAdapter(items);
        listRecyclerView.setAdapter(listAdapter);

        LinearLayoutManager listLayoutManager = new LinearLayoutManager(this);
        listLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listRecyclerView.setLayoutManager(listLayoutManager);
    }


    public ItemAdapter.OnItemClickListener itemClickListener= item -> {
        Log.e("Item Clicked",item.toString());
        listAdapter.notifyDataSetChanged();
//        listRecyclerView.scrollToPosition(0);
    };
}