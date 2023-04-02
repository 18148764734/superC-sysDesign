package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("八字实体类")
public class BaZi {

    @ApiModelProperty(value = "年柱",dataType = "string")
    private String nianZhu;
    @ApiModelProperty(value = "月柱",dataType = "string")
    private String yueZhu;
    @ApiModelProperty(value = "日柱",dataType = "string")
    private String riZhu;
    @ApiModelProperty(value = "时柱",dataType = "string")
    private String shiZhu;
    @ApiModelProperty(value = "八字加后缀年",dataType = "string")
    private String baZiNian;
    @ApiModelProperty(value = "八字加后缀月",dataType = "string")
    private String baZiYue;
    @ApiModelProperty(value = "八字加后缀日",dataType = "string")
    private String baZiRi;

    public String getBaZiNian() {
        return baZiNian;
    }

    public void setBaZiNian(String baZiNian) {
        this.baZiNian = baZiNian;
    }

    public String getBaZiYue() {
        return baZiYue;
    }

    public void setBaZiYue(String baZiYue) {
        this.baZiYue = baZiYue;
    }

    public String getBaZiRi() {
        return baZiRi;
    }

    public void setBaZiRi(String baZiRi) {
        this.baZiRi = baZiRi;
    }

    public String getNianZhu() {
        return nianZhu;
    }

    public void setNianZhu(String nianZhu) {
        this.nianZhu = nianZhu;
    }

    public String getYueZhu() {
        return yueZhu;
    }

    public void setYueZhu(String yueZhu) {
        this.yueZhu = yueZhu;
    }

    public String getRiZhu() {
        return riZhu;
    }

    public void setRiZhu(String riZhu) {
        this.riZhu = riZhu;
    }

    public String getShiZhu() {
        return shiZhu;
    }

    public void setShiZhu(String shiZhu) {
        this.shiZhu = shiZhu;
    }
}
