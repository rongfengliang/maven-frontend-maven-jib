package com.dalong;

import com.google.inject.Inject;
import com.xxl.job.core.executor.XxlJobExecutor;

import java.util.Set;

public class HandlerRegisry {
    private Set<MyAbstractJobHandler> handlerList ;
    @Inject
    public  HandlerRegisry(Set<MyAbstractJobHandler> list) {
        this.handlerList=list;
    }

    public  void handlerInit(){
        handlerList.forEach(iJobHandler -> {
            System.out.println(iJobHandler.getClass().toString());
            XxlJobExecutor.registJobHandler(iJobHandler.jobHandlerName(),iJobHandler);
        });
    }
}
