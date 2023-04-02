package com.baihe.controller;

import com.baihe.common.Result;
import com.baihe.entity.BaZi;
import com.baihe.entity.DaYun;
import com.baihe.entity.LiuNian;
import com.baihe.entity.Luner;
import com.baihe.utils.LiuNianUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/life")
@Api("获取八字，大运，流年信息")
public class LifeMessageController {

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "传入阴历日期，获取八字",notes ="需要的参数：nian，yue，ri，shi")
    @GetMapping("getbazi")
    public Result<BaZi> getBaZi(Luner luner){
        String[] baZi = LiuNianUtil.getBaZi(luner.getNian(), luner.getYue(), luner.getRi(), luner.getShi());
        BaZi baZi1 = new BaZi();
        baZi1.setNianZhu(baZi[0]);
        baZi1.setYueZhu(baZi[1]);
        baZi1.setRiZhu(baZi[2]);
        baZi1.setShiZhu(baZi[3]);
        return Result.success(baZi1);
    }


    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "传入阴历日期，获取流年",notes ="需要的参数：nian，yue，ri，shi，sex（0位女，1为男），daYunIndex")
    @GetMapping("getliunian")
    public Result<LiuNian> getLiuNian(Luner luner){
        String[] liuNianArr = LiuNianUtil.getLiuNian(luner.getNian(), luner.getYue(), luner.getRi(), luner.getShi(), luner.getGender(), luner.getDaYunIndex());
        LiuNian liuNian = new LiuNian();
        liuNian.setOne(liuNianArr[0]);
        liuNian.setTwo(liuNianArr[1]);
        liuNian.setThree(liuNianArr[2]);
        liuNian.setFour(liuNianArr[3]);
        liuNian.setFive(liuNianArr[4]);
        liuNian.setSix(liuNianArr[5]);
        liuNian.setSeven(liuNianArr[6]);
        liuNian.setEight(liuNianArr[7]);
        liuNian.setNine(liuNianArr[8]);
        liuNian.setTen(liuNianArr[9]);
        return Result.success(liuNian);
    }



    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "传入阴历日期，获取大运",notes ="需要的参数：nian，yue，ri，shi，sex（0位女，1为男）")
    @GetMapping("getdayun")
    public Result<DaYun> getDaYun(Luner luner){
        String[] daYunArr = LiuNianUtil.getDaYunArr(luner.getNian(), luner.getYue(), luner.getRi(), luner.getShi(), luner.getGender());
        DaYun daYun = new DaYun();
        daYun.setOne(daYunArr[0]);
        daYun.setTwo(daYunArr[1]);
        daYun.setThree(daYunArr[2]);
        daYun.setFour(daYunArr[3]);
        daYun.setFive(daYunArr[4]);
        daYun.setSix(daYunArr[5]);
        daYun.setSeven(daYunArr[6]);
        daYun.setEight(daYunArr[7]);
        daYun.setNine(daYunArr[8]);
        daYun.setTen(daYunArr[9]);
        return Result.success(daYun);
    }
}
