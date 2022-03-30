package com.example.index15_whoisundercover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.index15_whoisundercover.fragment.ConfigFragment;
import com.example.index15_whoisundercover.fragment.MyFragment;
import com.example.index15_whoisundercover.fragment.StartFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected MyFragment mMyFragment = new MyFragment();//我的
    protected ConfigFragment mConfigFragment = new ConfigFragment();//我的
    protected StartFragment mStartFragment = new StartFragment();//我的
    private LinearLayout mMenuStart;
    private LinearLayout mMenuConfig;
    private LinearLayout mMenuMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // 获取管理类
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content,mStartFragment)
                .add(R.id.container_content,mMyFragment).hide(mMyFragment)
                .add(R.id.container_content,mConfigFragment).hide(mConfigFragment)
                .commit();


    }

    private void initView() {
        mMenuMy = (LinearLayout) this.findViewById(R.id.menu_my);
        mMenuConfig = (LinearLayout) this.findViewById(R.id.menu_config);
        mMenuStart = (LinearLayout) this.findViewById(R.id.menu_start);

        mMenuMy.setOnClickListener(this);
        mMenuConfig.setOnClickListener(this);
        mMenuStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu_my:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mMyFragment)
                        .hide(mConfigFragment)
                        .hide(mStartFragment)
                        .commit();
                break;
            case R.id.menu_start:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMyFragment)
                        .hide(mConfigFragment)
                        .show(mStartFragment)
                        .commit();
                break;

            case R.id.menu_config:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mMyFragment)
                        .show(mConfigFragment)
                        .hide(mStartFragment)
                        .commit();
                break;


        }
    }
}