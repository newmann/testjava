package com.beiyelin.testjava.thread.service;

import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: newmann hu
 * @Date: created 10:59 2019-02-02
 * @Description:
 **/
//@Service
@Slf4j
public class AsyncTaskService {

    @Async
    public CompletableFuture<Void> executeAsyncTask(Integer i){
      log.info("执行异步任务".concat(String.valueOf(i)));
      return CompletableFuture.completedFuture(null);
    }

    @Async
    public CompletableFuture<Void> executeAsyncTaskPlus(Integer i){
        log.info("执行异步任务plus".concat(String.valueOf(i)));
        return CompletableFuture.completedFuture(null);
    }

}
