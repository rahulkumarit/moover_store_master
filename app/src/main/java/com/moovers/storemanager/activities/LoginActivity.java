package com.moovers.storemanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.moovers.storemanager.R;
import com.moovers.storemanager.utils.PopUtils;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtPhone, edtPassword;
    private Button btnSignIN;
    private RelativeLayout rlLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initComponents() {
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        rlLayout = findViewById(R.id.rlLayout);
        btnSignIN = findViewById(R.id.btnSignIN);
        btnSignIN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIN:
                clickOnLogin();
                break;
            default:
                break;
        }
    }

    private void clickOnLogin() {
        String name = edtPhone.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            PopUtils.showSnakBar(this, rlLayout, "Please Enter Phone Number.");
        } else if (TextUtils.isEmpty(password)) {
            PopUtils.showSnakBar(this, rlLayout, "Please Enter Password.");
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}

