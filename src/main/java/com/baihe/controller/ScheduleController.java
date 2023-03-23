package com.baihe.controller;

import com.baihe.common.Result;
import com.baihe.entity.BaZi;
import com.baihe.entity.Luner;
import com.baihe.entity.Schedule;
import com.baihe.service.ScheduleService;
import com.baihe.utils.LiuNianUtil;
import com.baihe.utils.SolarAndLunarUtil;
import com.baihe.vo.LunarVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "日程模块，包含八字接口 这里的接口都得先登录把token放在头部 ")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Resource
    private ScheduleService scheduleService;

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
    public Result<BaZi> getBaZi(Luner luner){
        String[] baZi = LiuNianUtil.getBaZi(luner.getNian(), luner.getYue(), luner.getRi(), luner.getShi());
        BaZi baZi1 = new BaZi();
        baZi1.setNianZhu(baZi[0]);
        baZi1.setYueZhu(baZi[1]);
        baZi1.setRiZhu(baZi[2]);
        baZi1.setShiZhu(baZi[3]);
        return Result.success(baZi1);
    }

    @ApiOperation(value = "添加日程",notes = "r"+
            "模板 {\n" +
            "    \"phone\":\"15119380977\",\n" +
            "    \"scheduleTime\":\"2023-02-26\",\n" +
            "    \"message\":\"123454646\"\n" +
            "}"+
            "成功返回值：{\n" +
            "    \"code\": \"0\",\n" +
            "    \"msg\": \"成功\",\n" +
            "    \"data\": null,\n" +
            "    \"username\": null\n" +
            "}" +
            "失败返回值:" +
            "{\n" +
            "    \"code\": \"2008\",\n" +
            "    \"msg\": \"此日期已经设置日程\",\n" +
            "    \"data\": null,\n" +
            "    \"username\": null\n" +
            "}" )
    @PostMapping("addschedule")
    public Result addSchedule(@RequestBody Schedule schedule){
        scheduleService.add(schedule);
        return  Result.success();
    }

    @ApiOperation(value = "查看当日某个日程" +
            "参数示例：\n" +
            "{\n" +
            "\"scheduleTime\":\"2023-02-27\",\n" +
            "\"scheduleId\":\"9\"\n" +
            "}\n" +
            "\n" +
            "成功返回值：\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": {\n" +
            "\"scheduleId\": 9,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-27\",\n" +
            "\"endTime\": \"2023-03-02 17:26:21\",\n" +
            "\"message\": \"1234666\"\n" +
            "},\n" +
            "\"username\": null\n" +
            "}\n" +
            "\n" +
            "\n" +
            "失败返回值：\n" +
            "{\n" +
            "\"code\": \"2009\",\n" +
            "\"msg\": \"此日期未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}"   )
    @GetMapping("queryoneschedule")
    public Result<Schedule> querySchedule(Schedule schedule){
        Schedule schedule1 = scheduleService.findByScheduleTime(schedule.getScheduleTime(), schedule.getScheduleId());
        return  Result.success(schedule1);
    }


    @ApiOperation(value = "查看当日所有日程" +
            "参数示例：\n" +
            "{\n" +
            "\"scheduleTime\":\"2023-02-27\",\n" +
            "\"phone\":\"15119380977\"\n" +
            "}\n" +
            "\n" +
            "成功返回值：\n" +
            "\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": [\n" +
            "{\n" +
            "\"scheduleId\": 9,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-27\",\n" +
            "\"endTime\": \"2023-03-02 17:26:21\",\n" +
            "\"message\": \"1234666\"\n" +
            "}\n" +
            "],\n" +
            "\"username\": null\n" +
            "}\n" +
            "\n" +
            "失败返回值：\n" +
            "{\n" +
            "\"code\": \"2009\",\n" +
            "\"msg\": \"此日期未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}"   )
    @GetMapping("queryallschedule")
    public Result<List<Schedule>> queryAllSchedule(Schedule schedule){
        List<Schedule> allByScheduleTime = scheduleService.findAllByScheduleTime(schedule.getScheduleTime(),schedule.getPhone());
        return  Result.success(allByScheduleTime);
    }

    @ApiOperation(value = "删除日程" +
            "模板 {\n" +
            "\"scheduleTime\":\"2023-02-27\",\n" +
            "\"scheduleId\":\"8\"\n" +
            "}"+
            "成功返回值：{\n" +
            "    \"code\": \"0\",\n" +
            "    \"msg\": \"成功\",\n" +
            "    \"data\": null,\n" +
            "    \"username\": null\n" +
            "}"
            +"失败返回值：\n" +
            "{\n" +
            "\"code\": \"2009\",\n" +
            "\"msg\": \"此日期未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}"   )
    @GetMapping("delschedule")
    public Result delSchedule(Schedule schedule){
        scheduleService.deleteByScheduleTime(schedule.getScheduleTime(),schedule.getScheduleId());
        return  Result.success();
    }

    @ApiOperation(value = "更新日程" +
            "模板 {\n" +
            "\"scheduleTime\":\"2023-02-27\",\n" +
            "\"scheduleId\":\"8\",\n" +
            "\"message\":\"000011111\"\n" +
            "}"+
            "成功返回值：{\n" +
            "    \"code\": \"0\",\n" +
            "    \"msg\": \"成功\",\n" +
            "    \"data\": null,\n" +
            "    \"username\": null\n" +
            "}"
            +"失败返回值：\n" +
            "{\n" +
            "\"code\": \"2009\",\n" +
            "\"msg\": \"此日期未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}"  )
    @PostMapping("updschedule")
    public Result updSchedule(@RequestBody Schedule schedule){
        scheduleService.updateByScheduleTime(schedule);
        return  Result.success();
    }


    @ApiOperation(value = "删除当日的所有日程"+
    "参数：\n" +
            "{\n" +
            "\"scheduleTime\":\"2023-02-27\",\n" +
            "\"phone\":\"15119380977\"\n" +
            "}\n" +
            "成功返回值：\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}\n" +
            "失败返回值：\n" +
            "{\n" +
            "\"code\": \"2009\",\n" +
            "\"msg\": \"此日期未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}")
    @GetMapping("delallschedule")
    public Result delAllSchedule(Schedule schedule){
        scheduleService.deleteAll(schedule.getScheduleTime(),schedule.getPhone());
        return  Result.success();
    }



    @ApiOperation(value = "通过年月获取已设置的日程"
            +"参数示例：\n" +
            "{\n" +
            "\"scheduleTime\":\"2023-02-08\",\n" +
            "\"phone\":\"15119380977\"\n" +
            "}\n" +
            "\n" +
            "\n" +
            "成功返回值：\n" +
            "{\n" +
            "\"code\": \"0\",\n" +
            "\"msg\": \"成功\",\n" +
            "\"data\": [\n" +
            "{\n" +
            "\"scheduleId\": 6,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-28\",\n" +
            "\"endTime\": \"2023-03-01 15:30:00\",\n" +
            "\"message\": \"123454646\"\n" +
            "},\n" +
            "{\n" +
            "\"scheduleId\": 7,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-26\",\n" +
            "\"endTime\": \"2023-03-01 15:30:20\",\n" +
            "\"message\": \"123454646\"\n" +
            "},\n" +
            "{\n" +
            "\"scheduleId\": 9,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-27\",\n" +
            "\"endTime\": \"2023-03-02 17:26:21\",\n" +
            "\"message\": \"1234666\"\n" +
            "},\n" +
            "{\n" +
            "\"scheduleId\": 10,\n" +
            "\"phone\": \"15119380977\",\n" +
            "\"scheduleTime\": \"2023-02-28\",\n" +
            "\"endTime\": \"2023-03-08 21:19:41\",\n" +
            "\"message\": \"123454646\"\n" +
            "}\n" +
            "],\n" +
            "\"username\": null\n" +
            "}\n" +
            "\n" +
            "\n" +
            "失败返回值：\n" +
            "{\n" +
            "\"code\": \"2008\",\n" +
            "\"msg\": \"此月未设置日程\",\n" +
            "\"data\": null,\n" +
            "\"username\": null\n" +
            "}")
    @GetMapping("getschedulebynianyue")
    public Result<List<Schedule>> getScheduleByNianYue(Schedule schedule){
        List<Schedule> list = scheduleService.findScheduleByYearAndMonth(schedule.getScheduleTime(), schedule.getPhone());
        return  Result.success(list);
    }


    @GetMapping("getschedulebynianyue1")
    public Result<LunarVo> getScheduleByNianYue1(Schedule schedule){
        return  Result.success(SolarAndLunarUtil.getAllDate(schedule));
    }

}
