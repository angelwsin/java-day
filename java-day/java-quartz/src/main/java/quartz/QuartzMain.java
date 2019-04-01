package quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class QuartzMain {


    public static void main(String[] args) {

        //"0 0/5 0 * * ?" cron表达式解析过程
        //org.quartz.CronExpression.buildExpression

        StringTokenizer exprsTok = new StringTokenizer("0 0/5 0 * * ?", " \t",
                false);

        while (exprsTok.hasMoreTokens()){
            System.out.println(exprsTok.nextToken());
        }

        //Trigger
        //org.quartz.core.QuartzSchedulerThread 线程监控Trigger

    }
}
