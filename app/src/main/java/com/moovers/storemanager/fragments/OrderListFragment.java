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
import com.moovers.storemanager.activities.MainActivity;
import com.moovers.storemanager.adapters.PreviousOrderAdapter;
import com.moovers.storemanager.adapters.TodayOrderAdapter;
import com.moovers.storemanager.listeners.RvListeners;

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
        todayOrders.clear();
        preOrders.clear();
        todayOrders.add("hello");
        preOrders.add("prev");
        preOrders.add("prev");
        todayOrders.add("hello");
        preOrders.add("prev");
        todayOrders.add("hello");
        preOrders.add("prev");
        rvTodayOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPreviuosOrder.setLayoutManager(new LinearLayoutManager(getContext()));
        setToolbar();
        todayOrderAdapter = new TodayOrderAdapter(getContext(), todayOrders, new RvListeners() {
            @Override
            public void onItemClick(View view, int pos) {
                OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.replaceFragmenr(orderDetailsFragment, orderDetailsFragment.getTag(), true);
            }
        });
        rvTodayOrder.setAdapter(todayOrderAdapter);
        rvTodayOrder.setNestedScrollingEnabled(false);
        previousOrderAdapter = new PreviousOrderAdapter(getContext(), preOrders, new RvListeners() {
            @Override
            public void onItemClick(View view, int pos) {

            }
        });
        rvPreviuosOrder.setAdapter(previousOrderAdapter);
        rvPreviuosOrder.setNestedScrollingEnabled(false);
    }


    private void setToolbar() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.imgCalender.setVisibility(View.GONE);
        mainActivity.imgAddProduct.setVisibility(View.GONE);
        mainActivity.rlNotification.setVisibility(View.VISIBLE);
        mainActivity.imgBack.setVisibility(View.GONE);
        mainActivity.imgMenu.setVisibility(View.VISIBLE);


    }


}
