package com.baihe.controller;

import com.baihe.common.Result;
import com.baihe.entity.BaZi;
import com.baihe.entity.Luner;
import com.baihe.entity.Schedule;
import com.baihe.service.ScheduleService;
import com.baihe.utils.LiuNianUtil;
import com.baihe.utils.SolarAndLunarUtil;
import com.baihe.utils.liunianmethods.Lunar;
import com.baihe.utils.liunianmethods.Solar;
import com.baihe.vo.AnimalAndTermsVo;
import com.baihe.vo.LunarVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "日程模块，包含八字接口 这里的接口都得先登录把token放在头部 ")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Resource
    private ScheduleService scheduleService;

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "传入阳历日期，获取八字",notes ="需要的参数：nian，yue，ri，shi")
    @GetMapping("getbazi")
    public Result<BaZi> getBaZi(Luner luner){
        Solar solar = new Solar(luner.getNian(), luner.getYue(), luner.getRi());
        Lunar lunar = solar.getLunar();
        String[] baZi = LiuNianUtil.getBaZi(lunar.getYear(), lunar.getMonth(), lunar.getDay(), luner.getShi());
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
    @ApiOperation(value = "传入阳历日期，获取八字年月日加后缀版",notes ="需要的参数：nian，yue，ri，shi")
    @GetMapping("getbazinianyueri")
    public Result<BaZi> getBaZiByNianYueRi(Luner luner){
        Solar solar = new Solar(luner.getNian(), luner.getYue(), luner.getRi());
        Lunar lunar = solar.getLunar();
        String[] baZi = LiuNianUtil.getBaZi(lunar.getYear(), lunar.getMonth(), lunar.getDay(), luner.getShi());
        BaZi baZi1 = new BaZi();
        baZi1.setBaZiNian(baZi[0]+"年");
        baZi1.setBaZiYue(baZi[1]+"月");
        baZi1.setBaZiRi(baZi[2]+"日");
        return Result.success(baZi1);
    }

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "添加日程",notes ="需要的参数：phone，scheduleTime，message")
    @PostMapping("addschedule")
    public Result addSchedule(@RequestBody Schedule schedule){
        scheduleService.add(schedule);
        return  Result.success();
    }

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "查看当日某个日程",notes ="需要的参数：scheduleId，scheduleTime")
    @GetMapping("queryoneschedule")
    public Result<Schedule> querySchedule(Schedule schedule){
        Schedule schedule1 = scheduleService.findByScheduleTime(schedule.getScheduleTime(), schedule.getScheduleId());
        return  Result.success(schedule1);
    }


    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "查看当日所有日程",notes ="需要的参数：phone，scheduleTime")
    @GetMapping("queryallschedule")
    public Result<List<Schedule>> queryAllSchedule(Schedule schedule){
        List<Schedule> allByScheduleTime = scheduleService.findAllByScheduleTime(schedule.getScheduleTime(),schedule.getPhone());
        return  Result.success(allByScheduleTime);
    }

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 2009,message = "此日期未设置日程")
    })
    @ApiOperation(value = "删除当日指定日程",notes ="需要的参数：scheduleId，scheduleTime")
    @DeleteMapping("delschedule")
    public Result delSchedule(Schedule schedule){
        scheduleService.deleteByScheduleTime(schedule.getScheduleTime(),schedule.getScheduleId());
        return  Result.success();
    }

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 2009,message = "此日期未设置日程")
    })
    @ApiOperation(value = "更新当日指定日程",notes ="需要的参数：scheduleId，scheduleTime，message")
    @PostMapping("updschedule")
    public Result updSchedule(@RequestBody Schedule schedule){
        scheduleService.updateByScheduleTime(schedule);
        return  Result.success();
    }


    @ApiResponses({
            @ApiResponse(code = 0,message = "成功"),
            @ApiResponse(code = 2009,message = "此日期未设置日程")
    })
    @ApiOperation(value = "删除当日的所有日程",notes ="需要的参数：phone，scheduleTime")
    @DeleteMapping("delallschedule")
    public Result delAllSchedule(Schedule schedule){
        scheduleService.deleteAll(schedule.getScheduleTime(),schedule.getPhone());
        return  Result.success();
    }



    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "通过年月获取已设置的日程",notes ="需要的参数：phone，scheduleTime")
    @GetMapping("getschedulebynianyue")
    public Result<List<Schedule>> getScheduleByNianYue(Schedule schedule){
        List<Schedule> list = scheduleService.findScheduleByYearAndMonth(schedule.getScheduleTime(), schedule.getPhone());
        return  Result.success(list);
    }


    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "通过年月获取信息（阴历，星期，节日，节气等）",notes ="需要的参数：phone，scheduleTime")
    @GetMapping("getschedulebynianyue1")
    public Result<LunarVo> getScheduleByNianYue1(Schedule schedule){
        return  Result.success(SolarAndLunarUtil.getAllDate(schedule));
    }

    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @ApiOperation(value = "通过年月获取生肖年和节气（持续）",notes ="需要的参数：scheduleTime")
    @GetMapping("getanimalandjieqibynianyue")
    public Result<AnimalAndTermsVo> getAnimalAndJieQiByNianYue(Schedule schedule){
        return  Result.success(SolarAndLunarUtil.getAnimal(schedule));
    }

}
