package com.moovers.storemanager.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.moovers.storemanager.R;

public class PopUtils {

    public static void showSnakBar(Context context, ViewGroup viewGroup, String message) {
        Snackbar mSnackBar = Snackbar.make(viewGroup, message, Snackbar.LENGTH_LONG);
        View view = mSnackBar.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        view.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        TextView mainTextView = (TextView) (view).findViewById(android.support.design.R.id.snackbar_text);
        mainTextView.setTextColor(Color.WHITE);
        mSnackBar.show();
     }


}
