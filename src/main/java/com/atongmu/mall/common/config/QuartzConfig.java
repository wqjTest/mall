package com.atongmu.mall.common.config;

import com.atongmu.mall.task.TestTask;
import org.quartz.*;

/**
 * @program: mall
 * @description: Quartz配置类
 * @author: Hus
 * @create: 2018-12-11 14:32
 */
//@Configuration
public class QuartzConfig {

    //@Bean
    public JobDetail testTaskDetail(){
        return JobBuilder.newJob(TestTask.class).withIdentity("testTask").storeDurably().build();
    }

    //@Bean
    public Trigger testTaskTrigger(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/20 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(testTaskDetail())
                .withIdentity("testTask")
                .withSchedule(scheduleBuilder)
                .build();
    }

}