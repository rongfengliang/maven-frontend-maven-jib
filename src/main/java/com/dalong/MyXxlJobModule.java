package com.dalong;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;
import com.xxl.job.core.executor.XxlJobExecutor;

public class MyXxlJobModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(XxlJobExecutor.class).toProvider(MyXxLJobExecutorProvider.class);
        Multibinder<MyAbstractJobHandler> jobHandlerMultibinder = Multibinder.newSetBinder(binder(), MyAbstractJobHandler.class);
        jobHandlerMultibinder.permitDuplicates();
        jobHandlerMultibinder.addBinding().to(Secondhandler.class);
        jobHandlerMultibinder.addBinding().to(JobHandler.class);
    }
}
