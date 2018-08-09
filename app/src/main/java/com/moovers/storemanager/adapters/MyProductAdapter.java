package com.moovers.storemanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moovers.storemanager.R;

import java.util.ArrayList;

/**
 * Created by SONI on 8/9/2018.
 */

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyProductHolder> {

    private Context context;
    private ArrayList<String> myProducts;
    private LayoutInflater inflater;


    public MyProductAdapter(Context context, ArrayList<String> myProducts) {
        this.context = context;
        this.myProducts = myProducts;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyProductHolder(inflater.inflate(R.layout.item_my_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyProductHolder extends RecyclerView.ViewHolder {

        public MyProductHolder(View itemView) {
            super(itemView);
        }
    }

}
