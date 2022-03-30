package com.imooc.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.imooc.demo.model.Food;
import com.imooc.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private RadioGroup mSexRadioGroup;
    private CheckBox mHotCheckBox, mFishCheckBox, mSourCheckBox;
    private SeekBar mSeekBar;
    private Button mSearchButton;
    private ImageView mFoodImageView;
    private ToggleButton mToggleButton;
    private List<Food> mFoods;
    private Person mPerson;
    private List<Food> mFoodResult;
    private boolean mIsFish;
    private boolean mIsSour;
    private boolean mIsHot;
    private int mPrice;
    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        findViews();

        // 初始化数据
        initData();

        // 为控件添加监听器，实现基本功能
        setListeners();

        // 自测

    }

    private void initData() {
        // new 出来一个空的食物 list
        mFoods = new ArrayList<>();

        // 初始化添加所有的数据
        mFoods.add(new Food("麻辣香锅", 55, R.drawable.malaxiangguo, true, false, false));
        mFoods.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
        mFoods.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));
        mFoods.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));
        mFoods.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        mFoods.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
        mFoods.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
        mFoods.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
        mFoods.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
        mFoods.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));
        mFoods.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false, true));

        mPerson = new Person();

        mFoodResult = new ArrayList<>();
    }

    private void findViews() {
        mNameEditText = findViewById(R.id.nameEditText);
        mSexRadioGroup = findViewById(R.id.sexRadioGroup);
        mHotCheckBox = findViewById(R.id.hotCheckBox);
        mFishCheckBox = findViewById(R.id.fishCheckBox);
        mSourCheckBox = findViewById(R.id.sourCheckBox);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setProgress(30);
        mSearchButton = findViewById(R.id.searchButton);
        mToggleButton = findViewById(R.id.showToggleButton);
        mToggleButton.setChecked(true);
        mFoodImageView = findViewById(R.id.foodImageView);
    }

    private void setListeners() {
        // 设置单选框listener
        mSexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.maleRadioButton:
                        mPerson.setSex("男");
                        break;
                    case R.id.femaleRadioButton:
                        mPerson.setSex("女");
                        break;
                }
            }
        });
        // 设置复选框listener
        mFishCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsFish = isChecked;
            }
        });
        mSourCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsSour = isChecked;
            }
        });
        mHotCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mIsHot = isChecked;
            }
        });


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mPrice = seekBar.getProgress();
                Toast.makeText(MainActivity.this, "价格： " + mPrice, Toast.LENGTH_SHORT).show();
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mToggleButton.isChecked()){
                    //  下一个菜
                        mCurrentIndex ++;
                    if(mCurrentIndex < mFoodResult.size()){
                        mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPic());
                    } else {
                        Toast.makeText(MainActivity.this, "没有啦", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 显示信息：菜的名称
                    if(mCurrentIndex < mFoodResult.size()){
                        Toast.makeText(MainActivity.this, "菜名： " + mFoodResult.get(mCurrentIndex).getName(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "没有啦", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // 查找菜品
    private void search() {
        // 结果列表每次都清空
        // 遍历所有菜
        // 如果符合条件，则加入到我们的结果列表中

        // 如果为空，先初始化
        if(mFoodResult == null){
            mFoodResult = new ArrayList<>();
        }

        // 先清除之前的结果
        mFoodResult.clear();
        // 当前显示的是结果中的第几个菜
        mCurrentIndex = 0;

        for (int index = 0; index < mFoods.size(); index++) {
            Food food = mFoods.get(index);
            if(food != null){
                // 价格要小于设定的价格
                // 是顾客选择的口味
                if(food.getPrice() < mPrice &&
                                    (food.isHot() ==  mIsHot
                                    || food.isFish() == mIsFish
                                    || food.isSour() == mIsFish)
                        ){
                    mFoodResult.add(food);
                }
            }
        }

        // 先显示第一张图片
        if(mCurrentIndex < mFoodResult.size()){
            mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPic());
        } else {
            mFoodImageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }


}
