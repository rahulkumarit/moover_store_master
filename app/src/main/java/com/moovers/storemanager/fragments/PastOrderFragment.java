package com.moovers.storemanager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moovers.storemanager.R;

/**
 * Created by SONI on 8/12/2018.
 */

public class PastOrderFragment extends BaseFragment {

    private RecyclerView rvPast;
    private LinearLayout llOrder, llRefresh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return (inflater.inflate(R.layout.fragment_past_order, container, false));

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llOrder = view.findViewById(R.id.llOrder);
        llRefresh = view.findViewById(R.id.llRefresh);
        rvPast = view.findViewById(R.id.rvPast);
        rvPast.setLayoutManager(new LinearLayoutManager(getContext()));
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() {

    }
}
