package com.dalong;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new BootStrapModule());
        ServiceStart serviceStart =  injector.getInstance(ServiceStart.class);
        serviceStart.appStart();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                serviceStart.appStop();
            } catch (Exception e) {
            }
        }));
    }
}