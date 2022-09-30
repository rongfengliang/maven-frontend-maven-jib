package com.dalong;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import spark.Service;

public class BootStrapModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new MyXxlJobModule());
        bind(Service.class).toProvider(new Provider<Service>() {
            @Override
            public Service get() {
                return Service.ignite();
            }
        }).in(Singleton.class);
    }
}
