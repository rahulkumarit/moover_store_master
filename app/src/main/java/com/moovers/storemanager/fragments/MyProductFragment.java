package com.moovers.storemanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moovers.storemanager.R;

public class MyProductFragment extends BaseFragment {

    private RecyclerView rvMyProduct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        inflater.inflate(R.layout.fragment_my_product, container, false);
        return null;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMyProduct = view.findViewById(R.id.rvMyProduct);
        rvMyProduct.setLayoutManager(new LinearLayoutManager(getContext()));
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
