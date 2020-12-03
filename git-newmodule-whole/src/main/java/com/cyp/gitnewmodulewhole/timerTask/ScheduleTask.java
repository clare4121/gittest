package com.cyp.gitnewmodulewhole.timerTask;


import com.cyp.gitnewmodulewhole.thread.impl.ScheduleImpl;
import com.cyp.gitnewmodulewhole.util.ConfigUtil;
import com.cyp.gitnewmodulewhole.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask implements SchedulingConfigurer {
    @Autowired
    private ScheduleUtil scheduleUtil;
    @Autowired
    private ConfigUtil configUtil;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
    scheduledTaskRegistrar.addCronTask(new Runnable() {
        @Override
        public void run() {

          scheduleUtil.getSchedule().doThing();
        }
    },configUtil.getCronfives());
    }
}
