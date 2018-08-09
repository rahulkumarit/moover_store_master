package com.moovers.storemanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moovers.storemanager.R;

import java.util.ArrayList;

public class TodayOrderAdapter extends RecyclerView.Adapter<TodayOrderAdapter.TodayViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> todayOrders;

    public TodayOrderAdapter(Context context, ArrayList<String> todayOrders) {
        this.context = context;
        this.todayOrders = todayOrders;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_today_order, parent, false);
        return new TodayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return todayOrders.size();
    }

    class TodayViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTodayOrder;
        TextView txtProductName, txtProductDeatails;

        public TodayViewHolder(View view) {
            super(view);
            imgTodayOrder = view.findViewById(R.id.imgTodayOrder);
            txtProductName = view.findViewById(R.id.txtProductName);
            txtProductDeatails = view.findViewById(R.id.txtProductDeatails);
        }
    }

}
