package com.baihe.vo;

import com.baihe.entity.AnimalAndTerms;

import java.util.List;

public class AnimalAndTermsVo {
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
