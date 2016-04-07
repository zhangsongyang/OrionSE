package cn.zsy.eg.spring.taskjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskJob {

    @Scheduled(cron = "*/2 * * * * ?")
    public void job1() {
        System.out.println("任务进行中。。。");
    }

}
