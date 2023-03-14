package com.baihe.dao;


import com.baihe.entity.Schedule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ScheduleDao extends Mapper<Schedule> {

    Schedule findByScheduleTime(@Param("scheduleTime")String scheduleTime,@Param("scheduleId")Long scheduleId);

    List<Schedule> findAllByScheduleTime(@Param("scheduleTime")String scheduleTime,@Param("phone")String phone);

    int deleteByScheduleTime(@Param("scheduleTime")String scheduleTime,@Param("scheduleId")Long scheduleId);

    int deleteAllScheduleByScheduleTime(@Param("scheduleTime")String scheduleTime,@Param("phone")String phone);

    List<Schedule>findScheduleByYearAndMonth(@Param("scheduleTime")String scheduleTime,@Param("phone")String phone);
    int updateByScheduleTime(Schedule schedule);
}
