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
import com.moovers.storemanager.listeners.RvListeners;

import java.util.ArrayList;

public class PreviousOrderAdapter extends RecyclerView.Adapter<PreviousOrderAdapter.PreviousViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> pOrders;
    private RvListeners rvListeners;

    public PreviousOrderAdapter(Context context, ArrayList<String> pOrders, RvListeners rvListeners) {
        this.context = context;
        this.pOrders = pOrders;
        this.rvListeners = rvListeners;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public PreviousViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PreviousViewHolder(inflater.inflate(R.layout.item_previous_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pOrders.size();
    }

    class PreviousViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPreviousOrder;
        TextView txtProductName, txtProductDeatails;

        public PreviousViewHolder(View view) {
            super(view);
            imgPreviousOrder = view.findViewById(R.id.imgPreviousOrder);
            txtProductName = view.findViewById(R.id.txtProductName);
            txtProductDeatails = view.findViewById(R.id.txtProductDeatails);
        }
    }

}
