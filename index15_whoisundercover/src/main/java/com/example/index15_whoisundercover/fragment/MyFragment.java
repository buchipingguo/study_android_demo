package com.example.index15_whoisundercover.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.index15_whoisundercover.R;

public class MyFragment extends Fragment {

    private Button mBtnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my,container,false);

    }

    //    @Nullable
//    @androidx.annotation.Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable @androidx.annotation.Nullable ViewGroup container, @Nullable @androidx.annotation.Nullable Bundle savedInstanceState) {
//
//        return inflater.inflate(R.layout.fragment_my,container,false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable @androidx.annotation.Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        // 监听点击登录事件
//        mBtnLogin = (Button) getView().findViewById(R.id.btn_login);
//        mBtnLogin.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                // 登录逻辑，待定；
//            }
//        });
//
//
//    }
}
