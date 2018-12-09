package com.example.zzpcomputer.exercise.thread;

import android.util.Log;

import com.example.zzpcomputer.exercise.utils.HttpMethod;
import com.example.zzpcomputer.exercise.utils.HttpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过http请求获取服务器传来的字符串
 */
@SuppressWarnings("all")
public class ProductHttpThread extends Thread{
    //用于保存服务器传输回来的内容
    private String result;
    @Override
    public void run() {
        try {
            URL url=new URL(HttpUtil.URL+"product");
            //获取连接
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            //获取流对象
            InputStream is=httpURLConnection.getInputStream();
            httpURLConnection.setRequestMethod(String.valueOf(HttpMethod.GET));
            httpURLConnection.setConnectTimeout(HttpUtil.TIME_OUT);
            InputStreamReader inputStreamReader=new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            String temp=null;
            while((temp=bufferedReader.readLine())!=null){
                stringBuffer.append(temp);
            }
            String str=stringBuffer.toString();
            Log.i("请求结果",str);
            setResult(stringBuffer.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getResult(){
        return result;
    }
    public void setResult(String result){
        this.result=result;
    }
}
