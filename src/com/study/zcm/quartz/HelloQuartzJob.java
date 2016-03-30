package com.study.zcm.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloQuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 System.out.println("Hello, Quartz! - executing its JOB at "+ 
		            new Date() + " by " + context.getTrigger().getName());
	}
}
