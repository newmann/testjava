package com.beiyelin.testjava;

import com.beiyelin.testjava.thread.config.TaskExecutorConfig;
import com.beiyelin.testjava.thread.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//@SpringBootApplication
@Slf4j
public class TestjavaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TestjavaApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService =context.getBean(AsyncTaskService.class);
        TaskExecutorConfig taskExecutorConfig = context.getBean(TaskExecutorConfig.class);

        CompletableFuture<Void> myjobs[] = new CompletableFuture[20];

        int j = 0;
        for(int i=0; i<10; i++){

            myjobs[j] = asyncTaskService.executeAsyncTask(i);
            j = j+1;
            myjobs[j] = asyncTaskService.executeAsyncTaskPlus(i);
            j = j+1;
        }


        context.close();

        CompletableFuture.allOf(myjobs).join();
        log.info("执行结束");
//        System.exit(0);
    }

}

