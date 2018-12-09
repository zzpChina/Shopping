package com.example.zzpcomputer.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.zzpcomputer.exercise.Bean.Product;
import com.example.zzpcomputer.exercise.thread.ProductHttpThread;

import java.util.List;

import com.example.zzpcomputer.exercise.adapter.ProductAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //线程对象
        ProductHttpThread productHttpThread=new ProductHttpThread();
        //启动线程
        productHttpThread.start();
        try {
            //线程优先
            productHttpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //数据，适配器，xml布局
        //通过JSOM将服务器传回的字符串转换成Product对象存入List
        List<Product> list= JSON.parseArray(productHttpThread.getResult(),Product.class);
        //创建适配器（当前activity，布局，List）
        ProductAdapter productAdapter=new ProductAdapter(this,R.layout.product_show_layout,list);
        ListView listView=findViewById(R.id.product_list_view);
        listView.setAdapter(productAdapter);
    }

}
