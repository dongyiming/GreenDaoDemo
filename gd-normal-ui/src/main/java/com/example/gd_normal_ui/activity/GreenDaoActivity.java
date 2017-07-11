package com.example.gd_normal_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gd_normal_ui.Controller.GreenDaoController;
import com.example.gd_normal_ui.R;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/10 15:09
 */
public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private GreenDaoController greenDaoController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        initWidgetEvent();
        initCompant();
    }

    private void initWidget() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
    }

    private void initWidgetEvent() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
    }

    private void initCompant() {

        greenDaoController = new GreenDaoController(this);
        greenDaoController.getAllMenuInfo();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_1) {//增加

        } else if (view.getId() == R.id.btn_2) {//删除

        } else if (view.getId() == R.id.btn_3) {//修改

        } else if (view.getId() == R.id.btn_4) {//查找

        } else if (view.getId() == R.id.btn_5) {//关联

        } else if (view.getId() == R.id.btn_6) {//分组

        } else if (view.getId() == R.id.btn_7) {//排序

        }
    }
}
