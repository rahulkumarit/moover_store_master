package com.moovers.storemanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moovers.storemanager.R;
import com.moovers.storemanager.activities.MainActivity;
import com.moovers.storemanager.adapters.MyProductAdapter;
import com.moovers.storemanager.listeners.RvListeners;

import java.util.ArrayList;

public class MyProductFragment extends BaseFragment implements RvListeners {

    private RecyclerView rvMyProduct;
    private MyProductAdapter myProductAdapter;
    private ArrayList<String> myProducts = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_my_product, container, false);
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
        setToolbar();
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProducts.add("1");
        myProductAdapter = new MyProductAdapter(getContext(), myProducts, this);
        rvMyProduct.setAdapter(myProductAdapter);
    }

    private void setToolbar() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.rlNotification.setVisibility(View.GONE);
        mainActivity.imgCalender.setVisibility(View.GONE);
        mainActivity.imgBack.setVisibility(View.GONE);
        mainActivity.imgMenu.setVisibility(View.VISIBLE);
        mainActivity.imgAddProduct.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(View view, int pos) {
        switch (view.getId()) {
            case R.id.imgSetting:
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getContext(), view);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getContext(), "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
                break;
            default:
                break;

        }
    }
}
