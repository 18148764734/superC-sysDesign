package com.baihe.vo;

import com.baihe.entity.DateMessage;

import java.util.List;

public class LunarVo {
    List<DateMessage>  allDate;

    public LunarVo(){

    }
    public List<DateMessage> getAllDate() {
        return allDate;
    }

    public void setAllDate(List<DateMessage> allDate) {
        this.allDate = allDate;
    }
}
