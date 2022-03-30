package com.example.index7_picking_up_brides.model;

import android.widget.ImageView;

public class Bride {
    private String name;
    private String country;
    private String birthday;
    private int pic;
    private int fans_num;
    private String comment;
    private ImageView mFoodImageView;

    public Bride(String name, String country, String birthday, int pic, int fans_num,String comment) {
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.pic = pic;
        this.fans_num = fans_num;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getbirthday() {
        return birthday;
    }

    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getFans_num() {
        return fans_num;
    }

    public void setFans_num(int fans_num) {
        this.fans_num = fans_num;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
