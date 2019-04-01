package quartz;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import quartz.job.JobTs;

public class Quartz {


    public static void main(String[] args) throws  Exception{

        //System.setProperty("user.timezone",)
        SchedulerFactory StdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = StdSchedulerFactory.getScheduler();
        //scheduler.addJob();
        scheduler.start();
        //scheduler.resumeTrigger();
        JobDetailImpl jobDetail = new JobDetailImpl();
        JobKey jobKey = new JobKey("test");
        jobDetail.setKey(jobKey);
        jobDetail.setJobClass(JobTs.class);
        //触发器
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setName("test");
        cronTrigger.setCronExpression("0/3 * * * * ?");
        TriggerKey triggerKey   = new TriggerKey("test");
        cronTrigger.setKey(triggerKey);
        scheduler.scheduleJob(jobDetail,cronTrigger);

        Thread.sleep(10000);

        //CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);
        //更新
        CronTriggerImpl newCronTrigger = new CronTriggerImpl();
        newCronTrigger.setName("test");
        newCronTrigger.setCronExpression("0/10 * * * * ?");

        scheduler.rescheduleJob(triggerKey,newCronTrigger);









    }
}
