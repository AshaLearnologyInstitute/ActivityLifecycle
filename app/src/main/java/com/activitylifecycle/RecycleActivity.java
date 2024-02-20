package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;

import com.activitylifecycle.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    List<Item> items;
    Button btnReNext,btnViewNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        btnReNext=findViewById(R.id.btnReNext);
        btnViewNext=findViewById(R.id.btnViewNext);

        items=new ArrayList<>();

        for(int i=0;i<20;i++){
            Item item=new Item((i+1000),"Tshirt-"+i,(1+i),(200.0f+i));
            items.add(item);
        }
//        Log.e("Data",items.toString());
        btnReNext.setOnClickListener(view -> {
            Intent intent=new Intent(RecycleActivity.this, ItemListActivity.class);

           /* intent.putParcelableArrayListExtra("ItemDetails", (ArrayList<? extends Parcelable>) items);
            startActivity(intent);*/

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ItemDetails", (ArrayList<? extends Parcelable>) items);
            intent.putExtras(bundle);
            startActivity(intent);
        });

        btnViewNext.setOnClickListener(view -> {
            Intent intent=new Intent(RecycleActivity.this, ViewPagerActivity.class);
            startActivity(intent);
        });

    }
}