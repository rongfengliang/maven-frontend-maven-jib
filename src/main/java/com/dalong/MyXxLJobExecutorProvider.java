package com.dalong;

import com.google.inject.Provider;
import com.xxl.job.core.executor.XxlJobExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyXxLJobExecutorProvider implements Provider<XxlJobExecutor> {
    Logger logger = LoggerFactory.getLogger(MyXxLJobExecutorProvider.class);
    private static  XxlJobExecutor  xxlJobExecutor = null;
    public   MyXxLJobExecutorProvider() {
        if(xxlJobExecutor==null){
            logger.info(">>>>>>>>>>> xxl-job config init.");
            XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
            xxlJobExecutor.setAdminAddresses("http://localhost:8080/xxljob-admin");
            xxlJobExecutor.setAppname("appname");
            xxlJobExecutor.setPort(9090);
            xxlJobExecutor.setAccessToken("demoapp");
            xxlJobExecutor.setLogPath("logPath");
            xxlJobExecutor.setLogRetentionDays(2);
            this.xxlJobExecutor=xxlJobExecutor;
        }
    }

    @Override
    public XxlJobExecutor get() {
        return this.xxlJobExecutor;
    }
}
