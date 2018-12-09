package com.example.zzpcomputer.exercise.thread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.zzpcomputer.exercise.utils.HttpUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * {"id":1,"image":"img/xl.jpg","num":0,"price":"￥1230.00","title":"复古夸张贝壳拼接幸运树圆形吊坠长款项链"}
 * {"id":2,"image":"img/xl2.jpg","num":0,"price":"￥2040.00","title":"女冰种黑耀石金曜石本命年情侣手串水晶饰品"}
 *
 * 传入一个图片路径，获取一个图片位图
 */
@SuppressWarnings("all")
public class ImageHttpThread extends Thread{
    //传入参数url,用于接收图片的路径
    private String imageUrl;
    //传入参数result
    private Bitmap resultBitmap;
    //图片线程传入一个在服务器中图片的相对路径
    public ImageHttpThread(String imageUrl){
        this.imageUrl=imageUrl;
    }

    @Override
    public void run() {
        try {
            //请求
            URL url=new URL(HttpUtil.URL +imageUrl);
            //获取连接
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            //获取图片的输入流
            InputStream inputStream=httpURLConnection.getInputStream();
            //通过工厂将图片的输入流转换成图片的位图
            setResultBitmap(BitmapFactory.decodeStream(inputStream));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Bitmap getResultBitmap() {
        return resultBitmap;
    }

    public void setResultBitmap(Bitmap resultBitmap) {
        this.resultBitmap = resultBitmap;
    }
}
