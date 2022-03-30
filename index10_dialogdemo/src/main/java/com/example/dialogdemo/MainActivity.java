package com.example.dialogdemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNormalDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("��ʾ");
        dialog.setMessage("��ȷ���˳�������");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    public void myClick(View view) {
        switch (view.getId()){
            case R.id.normal_dialog_btn:
                //AlertDialog�Ĺ��췽��ʱprotected
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("��ʾ");
                builder.setMessage("��ȷ���˳�������");
                builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("ȡ��",null);
                builder.show();
//                AlertDialog dialog = builder.create();
//                dialog.show();
                break;
            case R.id.diy_dialog_btn:
                MyDialog md = new MyDialog(this,R.style.mydialog);
                md.show();
                break;
            case R.id.popup_btn:
                showPopupWindow(view);
                break;
            case R.id.arrayAdapter_btn:
                showArrayDialog();
                break;
        }
    }
    private void showArrayDialog() {
        final String[] items = {"Java","Mysql","Android","HTML","C","JavaScript"};
        //����������
        //����1������
        //����2��������Դ������ָ����ÿһ�����������ֵ���ʽandroid.R.layout.xxx
        //����3������Դ
        // this,android.R.layout.simple_dropdown_item_1line ��ϵͳ�Դ��ģ�
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,items);
        // R.layout.array_item_layout���Լ�д��
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.array_item_layout,R.id.item_txt,items);
        AlertDialog.Builder builer = new AlertDialog.Builder(this)
                .setTitle("��ѡ��")
                //����1�����������󣨶�������ʾ��ʽ�Ĺ����ƶ�����
                //����2��������
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
        builer.show();
    }

    //����PopupWindow
    public void showPopupWindow(View view) {
        //׼����������Ҫ����ͼ����
        View v = LayoutInflater.from(this).inflate(R.layout.popup_layout,null);
        //1.ʵ��������
        //����1�����ڵ����е�View
        //����2��3�������Ŀ��
        //����4��focusable�����ܷ��ȡ����
        final PopupWindow window = new PopupWindow(v,600,80,true);

        //2.���ã�������������
        //���ñ���
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //��������Ӧ�ⲿ�ĵ���¼�
        window.setOutsideTouchable(true);
        //��������Ӧ����¼�
        window.setTouchable(true);
        //�ٴ���������Դ   �ڴ���һ��styleӦ�ö�����Դ    �۶Ե�ǰ�����Ķ����������Ϊ�ڶ�������Դ����
        window.setAnimationStyle(R.style.translate_anim);

        //3.��ʾ
        //����1(anchor)��ê
        //����2��3�������ê��x��y�����ϵ�ƫ����
        window.showAsDropDown(view,-190,0);

        //Ϊ�����е��ı���ӵ���¼�
        v.findViewById(R.id.choose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"�������ѡ��",Toast.LENGTH_SHORT).show();
                window.dismiss();   //���Ƶ�����ʧ
            }
        });

        v.findViewById(R.id.choose_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"�������ȫѡ",Toast.LENGTH_SHORT).show();
                window.dismiss();
            }
        });

        v.findViewById(R.id.copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"������˸���",Toast.LENGTH_SHORT).show();
                window.dismiss();
            }
        });
    }
}

