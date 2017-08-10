package com.jaycee88.layoutinflaterdemo;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class MainActivity extends AppCompatActivity {

    ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (ConstraintLayout) findViewById(R.id.main_layout);

        ViewParent viewParent = mainLayout.getParent();
        Log.d("TAG", "the parent of mainLayout is " + viewParent);

        // inflate(int resource, ViewGroup root, boolean attachToRoot)

        /*
         * 1. 如果root为null，attachToRoot将失去作用，设置任何值都没有意义。
         * 2. 如果root不为null，attachToRoot设为true，则会给加载的布局文件的指定一个父布局，即root。
         * 3. 如果root不为null，attachToRoot设为false，则会将布局文件最外层的所有layout属性进行设置，当该view被添加到父view当中时，这些layout属性会自动生效。
         * 4. 在不设置attachToRoot参数的情况下，如果root不为null，attachToRoot参数默认为true。
         */

        // button_layout 没有父容器
//        View buttonLayout = LayoutInflater.from(this).inflate(R.layout.button_layout_1, mainLayout, true);

        // button_layout 有父容器
        View buttonLayout = LayoutInflater.from(this).inflate(R.layout.button_layout_2, mainLayout, false);
        mainLayout.addView(buttonLayout);
    }
}
