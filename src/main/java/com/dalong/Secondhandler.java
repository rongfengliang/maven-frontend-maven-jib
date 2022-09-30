package com.dalong;

import com.xxl.job.core.context.XxlJobHelper;

public class Secondhandler extends MyAbstractJobHandler {
    @Override
    public void execute() throws Exception {
        System.out.println("second");
        XxlJobHelper.handleSuccess();
    }
    @Override
    public String jobHandlerName() {
        return "second";
    }
}
