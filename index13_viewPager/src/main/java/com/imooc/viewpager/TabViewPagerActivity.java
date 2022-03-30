package com.imooc.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Function:
 * Create date on 16/9/28.
 *
 * @author Conquer
 * @version 1.0
 */

public class TabViewPagerActivity extends AppCompatActivity implements TabHost.TabContentFactory{

    private TabHost mTabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_viewpager);

        // 初始化总布局
        mTabHost = (TabHost) findViewById(R.id.tab_host);
        mTabHost.setup();

        // 三个Tab 做处理

        // 1. init data
        int[] titleIDs = {
                R.string.home,
                R.string.message,
                R.string.me
        };
        int[] drawableIDs = {
                R.drawable.main_tab_icon_home,
                R.drawable.main_tab_icon_message, // 是个xml是个选择器，会有按下、选中的效果等；
                R.drawable.main_tab_icon_me
        };
        // data < -- > view

        for (int index = 0; index < titleIDs.length; index++) {

            View view = getLayoutInflater().inflate(R.layout.main_tab_layout, null, false);

            ImageView icon = (ImageView) view.findViewById(R.id.main_tab_icon);
            TextView title = (TextView) view.findViewById(R.id.main_tab_txt);
            View tab = view.findViewById(R.id.tab_bg);

            icon.setImageResource(drawableIDs[index]);  // 直接设置上xml就可自己选择了；
            title.setText(getString(titleIDs[index]));

            tab.setBackgroundColor(getResources().getColor(R.color.white));

            mTabHost.addTab(
                    mTabHost.newTabSpec(getString(titleIDs[index]))
                    .setIndicator(view)
                    .setContent(this)
            );




        }


        // 三个fragment组成的viewpager

        final Fragment[] fragments = new Fragment[]{
                TestFragment.newInstance("home"),
                TestFragment.newInstance("message"),
                TestFragment.newInstance("me")
        };
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(fragments.length); // 最多在内存中有几个页面，如果是100张图片那么设置100张不合理，但是这个次数比较少所以设置是可以的
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            // 取出对应的位置加载到adapter
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        // 监听横向滚动变化事件；
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                  if(mTabHost != null){
                      mTabHost.setCurrentTab(position);
                  }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 监听tab切换的事件；
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if (mTabHost != null) {
                    int position = mTabHost.getCurrentTab();
                    viewPager.setCurrentItem(position);
                }

            }
        });
    }

    // 设置一个tab需要的那个view，这个啥用没有，但是tab组件就是要用所以得写；
    @Override
    public View createTabContent(String s) {
        View view = new View(this);
        view.setMinimumHeight(0);
        view.setMinimumWidth(0);
        return view;
    }
}
