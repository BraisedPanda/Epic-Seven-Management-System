package com.braisedpanda.bean;

public class Goods {
    private String gid;
    private String gname;
    private Double price;
    private String introduction;
    private String detail;
    private Category category;
    private String image;
    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid='" + gid + '\'' +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", introduction='" + introduction + '\'' +
                ", detail='" + detail + '\'' +
                ", category=" + category +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
