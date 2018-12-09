package com.example.zzpcomputer.exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //数据，适配器，xml布局
        List<String> list= Arrays.asList("a","b","c");
        ProductAdapter productAdapter=new ProductAdapter(this,R.layout.product_show_layout,list);
        ListView listView=findViewById(R.id.product_list_view);
        listView.setAdapter(productAdapter);
    }
}
