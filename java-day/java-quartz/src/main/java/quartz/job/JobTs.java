package quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobTs implements Job {


    public void test(){
        System.out.println("job execution");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
          test();
    }
}
