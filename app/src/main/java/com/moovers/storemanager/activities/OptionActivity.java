package com.moovers.storemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.moovers.storemanager.R;

/**
 * Created by SONI on 8/8/2018.
 */

public class OptionActivity extends BaseActivity implements View.OnClickListener {

    private Button btnSignUp, btnSignIn;

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
