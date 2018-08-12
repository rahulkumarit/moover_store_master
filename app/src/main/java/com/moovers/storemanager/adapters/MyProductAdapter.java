package com.moovers.storemanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moovers.storemanager.R;
import com.moovers.storemanager.listeners.RvListeners;

import java.util.ArrayList;

/**
 * Created by SONI on 8/9/2018.
 */

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyProductHolder> {

    private Context context;
    private ArrayList<String> myProducts;
    private LayoutInflater inflater;
    private RvListeners rvListeners;


    public MyProductAdapter(Context context, ArrayList<String> myProducts, RvListeners rvListeners) {
        this.context = context;
        this.myProducts = myProducts;
        this.rvListeners = rvListeners;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyProductHolder(inflater.inflate(R.layout.item_my_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyProductHolder holder, final int position) {
        holder.imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvListeners.onItemClick(holder.imgSetting, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myProducts.size();
    }

    class MyProductHolder extends RecyclerView.ViewHolder {
        private ImageView imgSetting;

        public MyProductHolder(View view) {
            super(view);
            imgSetting = view.findViewById(R.id.imgSetting);
        }
    }

}
