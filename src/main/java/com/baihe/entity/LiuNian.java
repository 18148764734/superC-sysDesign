package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("流年实体类（每个流年都是具体的一年）")
public class LiuNian {

    @ApiModelProperty(value = "第一个流年",dataType = "string")
    private String one;
    @ApiModelProperty(value = "第二个流年",dataType = "string")
    private String two;
    @ApiModelProperty(value = "第三个流年",dataType = "string")
    private String three;
    @ApiModelProperty(value = "第四个流年",dataType = "string")
    private String four;
    @ApiModelProperty(value = "第五个流年",dataType = "string")
    private String five;
    @ApiModelProperty(value = "第六个流年",dataType = "string")
    private String six;
    @ApiModelProperty(value = "第七个流年",dataType = "string")
    private String seven;
    @ApiModelProperty(value = "第八个流年",dataType = "string")
    private String eight;
    @ApiModelProperty(value = "第九个流年",dataType = "string")
    private String nine;
    @ApiModelProperty(value = "第十个流年",dataType = "string")
    private String ten;

    public LiuNian(){

    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public String getEight() {
        return eight;
    }

    public void setEight(String eight) {
        this.eight = eight;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
