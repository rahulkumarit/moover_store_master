package com.moovers.storemanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moovers.storemanager.R;
import com.moovers.storemanager.adapters.PreviousOrderAdapter;
import com.moovers.storemanager.adapters.TodayOrderAdapter;

import java.util.ArrayList;

public class OrderListFragment extends BaseFragment {

    private TextView txtCurrentOrder;
    private RecyclerView rvTodayOrder, rvPreviuosOrder;
    private TodayOrderAdapter todayOrderAdapter;
    private PreviousOrderAdapter previousOrderAdapter;
    private ArrayList<String> todayOrders = new ArrayList<>();
    private ArrayList<String> preOrders = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_order_list, container, false);
     }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtCurrentOrder = view.findViewById(R.id.txtCurrentOrder);
        rvTodayOrder = view.findViewById(R.id.rvTodayOrder);
        rvPreviuosOrder = view.findViewById(R.id.rvPreviuosOrder);

        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() {
        todayOrders.add("hello");
        preOrders.add("prev");
        todayOrders.add("hello");
        preOrders.add("prev");
        todayOrders.add("hello");
        preOrders.add("prev");
        todayOrders.add("hello");
        preOrders.add("prev");
        rvTodayOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPreviuosOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        todayOrderAdapter = new TodayOrderAdapter(getContext(), todayOrders);
        previousOrderAdapter = new PreviousOrderAdapter(getContext(), preOrders);
        rvTodayOrder.setAdapter(todayOrderAdapter);
        rvPreviuosOrder.setAdapter(previousOrderAdapter);
     }
}
