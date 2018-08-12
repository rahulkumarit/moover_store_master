package com.moovers.storemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.moovers.storemanager.R;
import com.moovers.storemanager.utils.PopUtils;
import com.moovers.storemanager.utils.StaticUtils;

/**
 * Created by SONI on 8/8/2018.
 */

public class OptionActivity extends BaseActivity implements View.OnClickListener {

    private Button btnSignUp, btnSignIn;
    private RelativeLayout rlLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initComponents() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        rlLayout=findViewById(R.id.rlLayout);
        btnSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                goToLogin();
                break;
            case R.id.btnSignUp:
                PopUtils.showSnakBar(OptionActivity.this,rlLayout,"Sign up is not availale");
                break;
            default:
                break;
        }
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
