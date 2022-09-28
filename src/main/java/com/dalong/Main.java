package com.dalong;

import com.google.inject.*;
import spark.Service;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Service.class).toProvider(new Provider<Service>() {
                    @Override
                    public Service get() {
                        return  Service.ignite();
                    }
                }).in(Singleton.class);

            }

        });
        Service service = injector.getInstance(Service.class);
        service.port(4000);
        service.staticFileLocation("public");
        service.get("/v1/login", (req, res) -> {
            return "dalongdemo";
        });
    }
}