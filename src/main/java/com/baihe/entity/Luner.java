package com.baihe.entity;

import com.baihe.utils.liunianmethods.Lunar;

public class Luner {
    private int nian;
    private int yue;
    private int ri;
    private int shi;

    private int gender;

    private int daYunIndex;

    public Luner(){

    }

    public int getNian() {
        return nian;
    }



    public void setNian(int nian) {
        this.nian = nian;
    }

    public int getYue() {
        return yue;
    }

    public void setYue(int yue) {
        this.yue = yue;
    }

    public int getRi() {
        return ri;
    }

    public void setRi(int ri) {
        this.ri = ri;
    }

    public int getShi() {
        return shi;
    }

    public void setShi(int shi) {
        this.shi = shi;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDaYunIndex() {
        return daYunIndex;
    }

    public void setDaYunIndex(int daYunIndex) {
        this.daYunIndex = daYunIndex;
    }
}
