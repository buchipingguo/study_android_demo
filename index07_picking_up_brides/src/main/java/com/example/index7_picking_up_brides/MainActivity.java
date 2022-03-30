package com.example.index7_picking_up_brides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.index7_picking_up_brides.model.Bride;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Bride> bride_list;
    private Button mSearchButton;
    private Button mIsSheButton;
    private ImageView mFoodImageView;
    private EditText mNameEditText;


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

    }

    private void initData() {
        bride_list = new ArrayList<Bride>();
        bride_list.add(new Bride("波多野结衣","日本","1988-05-24",R.drawable.boduoyejieyi,10000,"波多野结衣因酷似台湾艺人林志玲，有AV界“志玲姐姐”之称，这也使得她刚出道时在中国就有很高的知名度，其实出道头两年她在日本名气普通，属于墙里开花墙外香，可以说中国人民真有眼光，随后她就凭着自己的努力一飞冲天，2014年获得DMM最佳女优大奖，同时销量也在2014年跃居榜首，可以说成为了近期日本女优界名副其实的NO.1。来自京都府，著名日本女演员，所属事务所T-POWERS，2013年最具人气的AV女忧排行榜第一名，2014年天空成人放送大赏年度最佳AV女忧，2015年搭档李康生出演台湾电影《沙西米》。"));
        bride_list.add(new Bride("吉泽明步","日本","1984-03-03",R.drawable.jizemingbu,20000,"吉泽明步，又名：吉沢明歩，来自东京都，是日本著名女演员，所属事务所AINA，兴趣爱好是美术馆、料理、网球、日本舞蹈，前日本女子偶像组合惠比寿麝香葡萄的成员，2007年获得日本“The AV Grand Prix”的第一名，2012年在日本AV30年人气投票中排名第三，2013年获得“日本成人放送大赏”最佳作品奖。2003年出道至今12年，依然活跃在AV界，生涯发片数量在400部左右，拍摄写真，电视剧，电影，综艺节目，各种活动走穴捞金无数，可以说正是因为她的勤奋工作，才有她如此大的成就，是现在还能看到的AV界为数不多的常青树！很多新入行的AV女优如麻生希等都视她为自己的偶像和榜样，都希望可以成为像她一样的AV天后。"));
        bride_list.add(new Bride("三上悠亚","日本","1993-08-16",R.drawable.sanshagnyouya,20000,"上悠亚，又名：鬼头桃菜，来自爱知县，是日本女演员，兴趣爱好是散步、偶像DVD鉴赏。三上悠亚是前SKE48中比较有名气的一位女演员叫鬼头桃菜，目前下海拍片改名为三上悠亚 （三上悠亜），同时这也是日本女子偶像组合中第七位下海拍AV的女优，鬼头桃菜1993年出生，身高159cm，清纯可爱，身材妖娆，一出道就在各大排行榜占据前列。"));
        bride_list.add(new Bride("桃谷绘里香","日本","1994-06-15",R.drawable.taoguhuilixiang,20000,"桃谷绘里香，又名：桃谷エリカ，来自东京都，是日本女演员，所属事务所ロータス東京，2013年底在MVG上用なな艺名，靠着一部网路配信下载的作品疯传网络。仅短短一个月时间就成为年度素人排名第6名，超越整年度素人AV的销售，创下史上最快销售纪录话题，获得MGS排行榜第一。桃谷绘里香（ Erika Momodani），1993年出生，目前是Presitige（蚊香社）公司的一名专属AV女优，2013年中以素人形式出道。凭借“豆腐西施”称号的一部作品在网上爆红，绝美容颜给人留下的深刻印像，吸引了广大宅男的关注的，可以说是爆红整个网络界！因为长着一张“清秀到会让其他女优自惭形秽的脸蛋”而在网上爆红的素人豆腐屋西施“なな”于2014年2月份正式出道。"));
        bride_list.add(new Bride("天海翼","日本","1984-03-03",R.drawable.tianhaiyi,340000,"天海翼，又名：天海つばさ，来自广岛县，是日本女演员，所属事务所名東，兴趣爱好是宠物，曾被赋予了“最高の美女”（最棒的美女）的美称。 天海翼（天海つばさ / あまみ つばさ），1988年出生，2009年出道，出道以来一直在idea pocket公司发片，属于IP公司的台柱子，天海翼身高160cm，E罩杯的魔鬼身材，加上清纯的天使面孔，idea pocket的优质封面设计和良好的拍摄技巧，也是她的事业平步青云，如虎添翼，让她俘获了众多两岸三地骚年的心，如果说天海翼有什么缺点的话，她的声音不是很好听似乎是她唯一的弱点。"));
        bride_list.add(new Bride("宇都宫紫苑","日本","1984-03-03",R.drawable.yudugongziyuan,5000,"宇都宫紫苑，又名：RION，安斋拉拉，来自京都府，是日本著名女演员，所属事务所T-POWERS，兴趣爱好是游泳，以黄金比例的身材备受瞩目。 宇都宫紫苑1994年出生，身高161cm，2013年出道，在AV界最牛的S1公司红极一时，只要是她的片子已发布，立刻可以做到S1当月的前三名，可以说是所向披靡，连同合集一共发行12部作品，2014年底宣布引退，2015年底改名RION复出。宇都宫紫苑被很多网友称为神之乳，她的身材从某种程度上来说好的不科学，但是真的是自然的哦，真感慨大自然的鬼斧神工，J罩杯的宇都宮しをん腰肢纤细，身材匀称，这种身材真的是可遇而不可求，同时宇都MM还有很好听的声音和不错的演技哦！"));
    }

    private void findViews() {
        mSearchButton = findViewById(R.id.searchButton);
        mIsSheButton = findViewById(R.id.isSheButton);
        mFoodImageView = findViewById(R.id.girlImageView);
        mNameEditText = findViewById(R.id.nameEditText);
        findViewById(R.id.countryType);

    }

    private void setListeners() {


        mSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                search();
            }


        });
        mIsSheButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goToWeb();
            }


        });
    }

    private void goToWeb() {
        Uri uri = Uri.parse("https://www.234567av.com/list-67.html");    //设置跳转的网站
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    private void search() {
        mFoodImageView.setImageResource(R.drawable.sanshagnyouya);
    }
}