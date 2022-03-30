package com.example.index15_whoisundercover.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.index15_whoisundercover.R;
import com.example.index15_whoisundercover.adapter.MainHeaderAdAdapter;
import com.example.index15_whoisundercover.util.DataUtil;

public class StartFragment extends Fragment {

    protected int[] adPicIdList = {R.drawable.ad02,R.drawable.ad011,R.drawable.ad03};


    private ViewPager mVPagerHeaderAd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mVPagerHeaderAd = (ViewPager) getView().findViewById(R.id.vpager_main_header_ad);
        MainHeaderAdAdapter mMainHeaderAdAdapter = new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAddInfo(getActivity(), adPicIdList));
        mVPagerHeaderAd.setAdapter(mMainHeaderAdAdapter);
    }
}
