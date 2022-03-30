package com.example.index15_whoisundercover.util;

import android.content.Context;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {


    public static List<ImageView> getHeaderAddInfo(Context context,int adPicList[]){
        List<ImageView> datas = new ArrayList<>();
        for (int i = 0; i <adPicList.length; i++) {
            ImageView picView = new ImageView(context);
            // 一会在放开看 这个会像一个好的缩放；
            picView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            picView.setImageResource(adPicList[i]);
            datas.add(picView);
        }
        return datas;
    }
}
