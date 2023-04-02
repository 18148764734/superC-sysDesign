package com.baihe.vo;

import com.baihe.entity.DateMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("通过年月返回的一个月的大量信息（节气，节日，阴历，阳历等）")
public class LunarVo {
    @ApiModelProperty("所有信息的集合")
    private List<DateMessage>  allDate;

    public LunarVo(){

    }
    public List<DateMessage> getAllDate() {
        return allDate;
    }

    public void setAllDate(List<DateMessage> allDate) {
        this.allDate = allDate;
    }
}
