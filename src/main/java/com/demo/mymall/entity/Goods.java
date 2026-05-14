package com.demo.mymall.entity;

//数据库表对应的类

public class Goods {
    private Integer id;
    private String name;
    private Double price;
    private String image;
    private String detail;

    // 生成 getter 和 setter（右键 → Generate → Getter and Setter）
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }
}