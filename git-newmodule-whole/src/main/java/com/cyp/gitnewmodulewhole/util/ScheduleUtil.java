package com.cyp.gitnewmodulewhole.util;

import com.cyp.gitnewmodulewhole.thread.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScheduleUtil {
	@Resource
    private Schedule  schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
