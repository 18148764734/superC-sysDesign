package com.baihe.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("生肖年和当日节气信息类")
public class AnimalAndTerms {
    @ApiModelProperty("生肖")
    private String animal;

    @ApiModelProperty("节气")
    private String jieQi;


    @ApiModelProperty(value = "日期",dataType = "int")
    private int day;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public AnimalAndTerms(){

    }
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getJieQi() {
        return jieQi;
    }

    public void setJieQi(String jieQi) {
        this.jieQi = jieQi;
    }
}
