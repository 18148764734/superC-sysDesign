package com.baihe.vo;

import com.baihe.entity.AnimalAndTerms;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("一个月的生肖年和节气信息类")
public class AnimalAndTermsVo {

    @ApiModelProperty("返回的类集合")
    private List<AnimalAndTerms> allJieQiAndCurrentAnimal;

    public AnimalAndTermsVo(){

    }
    public List<AnimalAndTerms> getAllJieQiAndCurrentAnimal() {
        return allJieQiAndCurrentAnimal;
    }

    public void setAllJieQiAndCurrentAnimal(List<AnimalAndTerms> allJieQiAndCurrentAnimal) {
        this.allJieQiAndCurrentAnimal = allJieQiAndCurrentAnimal;
    }
}
