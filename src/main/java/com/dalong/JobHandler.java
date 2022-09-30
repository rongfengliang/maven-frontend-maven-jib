package com.dalong;

import com.xxl.job.core.context.XxlJobHelper;

public class JobHandler extends MyAbstractJobHandler {

    @Override
    public String jobHandlerName() {
        return "first";
    }

    @Override
    public void execute() throws Exception {
        System.out.println("first");
        XxlJobHelper.handleSuccess();
    }
}
