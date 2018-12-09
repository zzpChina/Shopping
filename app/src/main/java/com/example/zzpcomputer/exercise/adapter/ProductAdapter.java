package com.example.zzpcomputer.exercise.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zzpcomputer.exercise.Bean.Product;
import com.example.zzpcomputer.exercise.R;
import com.example.zzpcomputer.exercise.thread.ImageHttpThread;

import java.util.List;

@SuppressWarnings("all")
public class ProductAdapter extends ArrayAdapter {

    private int resourceId;
    /*
    三个参数的 含义：
        1.上下文，也就是当前的Activity
        2.resouce：指的是显示的布局
        3.要显示的数据
     */
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }

    /**
     * 显示一个对象就会执行一个此方法
     * @param position：list要显示的条数
     * @param convertView：要返回出去的视图
     * @param parent：加载对应的xml
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //获取商品对象
        Product product= (Product) getItem(position);
        //获取一个Item
        ProductLayout productLayout=new ProductLayout();
        View view;
        /*
        * 如果说返回的view为空，获取返回的视图，并且把返回的视图赋值给Item对象，并且缓存起来
        *如果不为空，直接获取返回的View给Item
        */
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            productLayout.titleView=view.findViewById(R.id.title);
            productLayout.priceView=view.findViewById(R.id.price);
            productLayout.imageView=view.findViewById(R.id.img);
            //将获取的View缓存起来
            view.setTag(productLayout);
        }else{
            view=convertView;
            productLayout= (ProductLayout) view.getTag();
        }
        //为Item设置值
         productLayout.titleView.setText(product.getTitle());
         productLayout.priceView.setText(product.getPrice());
        /**
         * 在获得每一个Item的时候都建立一个线程获取图片
         */
        ImageHttpThread imageHttpThread=new ImageHttpThread(product.getImage());
        imageHttpThread.start();
        try {
            //获取图片的线程优先
            imageHttpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置图片
        productLayout.imageView.setImageBitmap(imageHttpThread.getResultBitmap());
        return view;
    }

    /**
     * 一个Item类
     */
    class ProductLayout{
        TextView titleView;
        TextView priceView;
        ImageView imageView;
        Button addButton;
    }
}
