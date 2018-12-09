package com.example.zzpcomputer.exercise.Bean;

/**
 * 产品实体类
 */
@SuppressWarnings("all")
public class Product {
    private int id;
    private String image;
    private  int num;
    private String price;
    private String title;
    public Product(){

    }
    public Product(int id, String image, int num, String price, String title) {
        this.id = id;
        this.image = image;
        this.num = num;
        this.price = price;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
