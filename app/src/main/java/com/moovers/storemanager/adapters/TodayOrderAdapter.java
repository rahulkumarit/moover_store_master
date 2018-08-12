package com.moovers.storemanager.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moovers.storemanager.R;
import com.moovers.storemanager.listeners.RvListeners;

import java.util.ArrayList;

public class TodayOrderAdapter extends RecyclerView.Adapter<TodayOrderAdapter.TodayViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> todayOrders;
    private RvListeners rvListeners;

    public TodayOrderAdapter(Context context, ArrayList<String> todayOrders, RvListeners rvListeners) {
        this.context = context;
        this.todayOrders = todayOrders;
        this.rvListeners = rvListeners;
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
        holder.rlTodayOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvListeners.onItemClick(holder.rlTodayOrder, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return todayOrders.size();
    }

    class TodayViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTodayOrder;
        TextView txtProductName, txtProductDeatails;
        RelativeLayout rlTodayOrder;


        public TodayViewHolder(View view) {
            super(view);
            imgTodayOrder = view.findViewById(R.id.imgTodayOrder);
            txtProductName = view.findViewById(R.id.txtProductName);
            txtProductDeatails = view.findViewById(R.id.txtProductDeatails);
            rlTodayOrder = view.findViewById(R.id.rlTodayOrder);
        }
    }

}
