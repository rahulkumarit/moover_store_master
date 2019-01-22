package com.moovers.storemanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moovers.storemanager.R;
import com.moovers.storemanager.activities.MainActivity;

public class ReportsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_report_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initComponents() {
        setToolbar();
    }

    private void setToolbar() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.imgCalender.setVisibility(View.GONE);
        mainActivity.imgAddProduct.setVisibility(View.GONE);
        mainActivity.imgBack.setVisibility(View.GONE);
        mainActivity.imgMenu.setVisibility(View.VISIBLE);
        mainActivity.rlNotification.setVisibility(View.VISIBLE);

    }

}
