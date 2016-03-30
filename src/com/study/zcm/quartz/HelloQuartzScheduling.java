package com.study.zcm.quartz;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class HelloQuartzScheduling {
	
	public static void main(String[] args)throws SchedulerException, ParseException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // ������
        Scheduler scheduler = schedulerFactory.getScheduler();

        // ��ҵ
        JobDetail jobDetail = new JobDetail("helloQuartzJob", 
                Scheduler.DEFAULT_GROUP, HelloQuartzJob.class);

        /*// ������SimpleTrigger
        SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger", 
                Scheduler.DEFAULT_GROUP);

        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()));
        simpleTrigger.setRepeatInterval(5000);
        simpleTrigger.setRepeatCount(10);*/
        
        //scheduler.scheduleJob(jobDetail, simpleTrigger);
        
        // ������CronTrigger
        String cronExpression = "30/5 * * * * ?"; // ÿ���ӵ�30s��ÿ5s��������        
        CronTrigger cronTrigger = new CronTrigger("cronTrigger", 
                Scheduler.DEFAULT_GROUP, cronExpression);

        scheduler.scheduleJob(jobDetail, cronTrigger);

        scheduler.start();
    }
}
