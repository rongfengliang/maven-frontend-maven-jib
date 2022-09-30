package com.dalong;

import com.google.inject.Inject;
import com.xxl.job.core.executor.XxlJobExecutor;
import spark.Service;

public class ServiceStart {

    @Inject
    private Service service;

    @Inject
    private XxlJobExecutor xxlJobExecutor;

    @Inject
    private HandlerRegisry handlerRegisry;

    public void appStart() throws Exception {
        handlerRegisry.handlerInit();
        // service init
        service.port(4000);
        service.staticFileLocation("public");
        service.get("/v1/login", (req, res) -> {
            return "ok";
        });
        // xxljob init
        xxlJobExecutor.start();
    }

    public void appStop() {
        service.stop();
        xxlJobExecutor.destroy();
    }
}
