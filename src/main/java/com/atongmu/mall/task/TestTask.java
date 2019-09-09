package com.atongmu.mall.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @program: mall
 * @description: Quartz测试类
 * @author: Hus
 * @create: 2018-12-11 14:36
 */
@DisallowConcurrentExecution
public class TestTask extends QuartzJobBean {

    /**
     * Execute the actual job. The job data map will already have been
     * applied as bean property values by execute. The contract is
     * exactly the same as for the standard Quartz execute method.
     *
     * @param context
     * @see #execute
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    }

}