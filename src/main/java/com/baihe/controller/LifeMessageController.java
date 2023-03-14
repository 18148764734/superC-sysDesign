package com.baihe.controller;

import com.baihe.common.Result;
import com.baihe.entity.BaZi;
import com.baihe.entity.DaYun;
import com.baihe.entity.LiuNian;
import com.baihe.entity.Luner;
import com.baihe.utils.LiuNianUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/life")
@Api("获取八字，大运，流年信息")
public class LifeMessageController {

    @ApiOperation(value = "获取八字" +
            "模板 {\n" +
            "    \"nian\":\"2002\",\n" +
            "    \"yue\":\"1\",\n" +
            "    \"ri\":\"12\",\n" +
            "    \"shi\":\"12\"\n" +
            "}"+
            "返回值：{\n" +
            "    \"code\": \"0\",\n" +
            "    \"msg\": \"成功\",\n" +
            "    \"data\": {\n" +
            "        \"nianZhu\": \"壬午\",\n" +
            "        \"yueZhu\": \"壬寅\",\n" +
            "        \"riZhu\": \"壬戌\",\n" +
            "        \"shiZhu\": \"丙午\"\n" +
            "    },\n" +
            "    \"username\": null\n" +
            "}"   )
    @GetMapping("getbazi")
    public Result<BaZi> getBaZi(@RequestBody Luner luner){
        String[] baZi = LiuNianUtil.getBaZi(luner.getNian(), luner.getYue(), luner.getRi(), luner.getShi());
        BaZi baZi1 = new BaZi();
        baZi1.setNianZhu(baZi[0]);
        baZi1.setYueZhu(baZi[1]);
        baZi1.setRiZhu(baZi[2]);
        baZi1.setShiZhu(baZi[3]);
        return Result.success(baZi1);
    }



    @ApiOperation("获取流年"
            +"参数示例：\n" +
            "{\n" +
            "\"nian\":\"2002\",\n" +
            "\"yue\":\"1\",\n" +
            "\"ri\":\"12\",\n" +
            "\"shi\":\"12\",\n" +
            "\"gender\":\"0\",\n" +
            "\"daYunIndex\":\"0\"\n" +
            "}\n" +
            "返回值：\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": {\n" +
            "\"one\": \"2008 戊子\",\n" +
            "\"two\": \"2009 己丑\",\n" +
            "\"three\": \"2010 庚寅\",\n" +
            "\"four\": \"2011 辛卯\",\n" +
            "\"five\": \"2012 壬辰\",\n" +
            "\"six\": \"2013 癸巳\",\n" +
            "\"seven\": \"2014 甲午\",\n" +
            "\"eight\": \"2015 乙未\",\n" +
            "\"nine\": \"2016 丙申\",\n" +
            "\"ten\": \"2017 丁酉\"\n" +
            "},\n" +
            "\"username\": null\n" +
            "}\n")
    @GetMapping("getliunian")
    public Result<LiuNian> getLiuNian(@RequestBody Luner luner){
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



    @ApiOperation("获取大运"
            +"参数示例：\n" +
            "{\n" +
            "\"nian\":\"2002\",\n" +
            "\"yue\":\"1\",\n" +
            "\"ri\":\"12\",\n" +
            "\"shi\":\"12\",\n" +
            "\"gender\":\"0\"\n" +
            "}\n" +
            "\n" +
            "\n" +
            "返回值：\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": {\n" +
            "\"one\": \"7岁~16岁  [2008年-2017年]  辛丑\",\n" +
            "\"two\": \"17岁~26岁  [2018年-2027年]  庚子\",\n" +
            "\"three\": \"27岁~36岁  [2028年-2037年]  己亥\",\n" +
            "\"four\": \"37岁~46岁  [2038年-2047年]  戊戌\",\n" +
            "\"five\": \"47岁~56岁  [2048年-2057年]  丁酉\",\n" +
            "\"six\": \"57岁~66岁  [2058年-2067年]  丙申\",\n" +
            "\"seven\": \"67岁~76岁  [2068年-2077年]  乙未\",\n" +
            "\"eight\": \"77岁~86岁  [2078年-2087年]  甲午\",\n" +
            "\"nine\": \"87岁~96岁  [2088年-2097年]  癸巳\",\n" +
            "\"ten\": \"97岁~106岁  [2098年-2107年]  壬辰\"\n" +
            "},\n" +
            "\"username\": null\n" +
            "}")
    @GetMapping("getdayun")
    public Result<DaYun> getDaYun(@RequestBody Luner luner){
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
