package com.baihe.service;

import com.baihe.entity.Schedule;
import com.baihe.entity.Sms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleService {
    Schedule add(Schedule schedule);

    void delete(Long scheduleId);

    void deleteAll(String scheduleTime,String phone);

    List<Schedule> findScheduleByYearAndMonth(String scheduleTime,String phone);

    void update(Schedule schedule);

    Schedule findByScheduleTime(String scheduleTime,Long scheduleId);
    List<Schedule> findAllByScheduleTime(String scheduleTime,String phone);
    void deleteByScheduleTime(String scheduleTime,Long scheduleId);
    void updateByScheduleTime(Schedule schedule);
}
