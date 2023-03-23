package com.baihe.service.impl;

import com.baihe.common.ResultCode;
import com.baihe.dao.ScheduleDao;
import com.baihe.entity.Schedule;
import com.baihe.exception.CustomException;
import com.baihe.service.ScheduleService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleDao scheduleDao;

    @Override
    public Schedule add(Schedule schedule) {
        schedule.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        scheduleDao.insertSelective(schedule);
        return schedule;
    }

    @Override
    public void delete(Long scheduleId) {
        scheduleDao.deleteByPrimaryKey(scheduleId);
    }


    @Override
    public void deleteAll(String scheduleTime,String phone) {
        List<Schedule> list = scheduleDao.findAllByScheduleTime(scheduleTime,phone);
        if (list.size()==0){
            throw  new CustomException(ResultCode.SCHEDULE_MESSAGE_EXIST);
        }
        scheduleDao.deleteAllScheduleByScheduleTime(scheduleTime,phone);
    }

    @Override
    public List<Schedule> findScheduleByYearAndMonth(String scheduleTime,String phone) {
        String nianYue=scheduleTime.substring(0,7);
        List<Schedule> list = scheduleDao.findScheduleByYearAndMonth(nianYue, phone);
        return list;
    }


    @Override
    public void update(Schedule schedule) {

    }

    @Override
    public Schedule findByScheduleTime(String scheduleTime,Long scheduleId) {
        Schedule schedule1 = scheduleDao.findByScheduleTime(scheduleTime,scheduleId);
        if (schedule1==null){
            throw  new CustomException(ResultCode.SCHEDULE_MESSAGE_EXIST);
        }
        return schedule1;

    }

    @Override
    public List<Schedule> findAllByScheduleTime(String scheduleTime,String phone) {
        List<Schedule> list = scheduleDao.findAllByScheduleTime(scheduleTime,phone);
        if (list.size()==0){
            throw  new CustomException(ResultCode.SCHEDULE_MESSAGE_EXIST);
        }
        return list;
    }

    @Override
    public void deleteByScheduleTime(String scheduleTime,Long scheduleId) {
        Schedule schedule1 = scheduleDao.findByScheduleTime(scheduleTime,scheduleId);
        if (schedule1==null){
            throw  new CustomException(ResultCode.SCHEDULE_MESSAGE_EXIST);
        }
        scheduleDao.deleteByScheduleTime(scheduleTime,scheduleId);
    }

    @Override
    public void updateByScheduleTime(Schedule schedule) {
        Schedule schedule1 = scheduleDao.findByScheduleTime(schedule.getScheduleTime(), schedule.getScheduleId());
        if (schedule1==null){
            throw  new CustomException(ResultCode.SCHEDULE_MESSAGE_EXIST);
        }
        schedule.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        scheduleDao.updateByPrimaryKeySelective(schedule);
    }
}
