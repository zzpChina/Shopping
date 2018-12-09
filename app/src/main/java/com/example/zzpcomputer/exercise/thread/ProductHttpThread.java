package com.example.zzpcomputer.exercise.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过http请求获取服务器传来的对象
 */
public class ProductHttpThread extends Thread{
    //用于保存服务器传输回来的内容
    private String result;
    @Override
    public void run() {
        try {
            URL url=new URL("http://119.29.60.170:8080/shopping/product");
            //获取连接
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            //获取流对象
            InputStream is=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer result=new StringBuffer();
            String temp=null;
            while((temp=bufferedReader.readLine())!=null){
                result.append(temp);
            }
            setResult(result.toString());
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
