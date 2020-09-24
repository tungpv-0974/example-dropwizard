package com.tungpv.example;

import com.tungpv.example.resource.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainApplication extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            new MainApplication().run(new String[]{"server", "config.yml"});
        } else {
            new MainApplication().run(args);
        }
    }

    @Override
    public String getName() {
        return "example-app";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
    }

    @Override
    public void run(AppConfig configuration, Environment environment) {

        environment.jersey().register(new UserResource());
    }
}
