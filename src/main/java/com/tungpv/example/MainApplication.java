package com.tungpv.example;

import com.google.common.collect.ImmutableList;
import com.tungpv.example.config.thymeleaf.ThymeleafViewRenderer;
import com.tungpv.example.resource.UserResource;
import com.tungpv.example.resource.UserViewResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import lombok.Getter;

import java.util.Map;

@Getter
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

        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        bootstrap.addBundle(new ViewBundle<AppConfig>(ImmutableList.of(new ThymeleafViewRenderer())) {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(final AppConfig configuration) {
                return configuration.views;
            }
        });

        bootstrap.addBundle(new AssetsBundle("/templates/com/tungpv/example/resource/web/assets/", "/assets"));
        bootstrap.addBundle(new AssetsBundle("/META-INF/resources/webjars", "/webjars", null, "webjars"));

    }

    @Override
    public void run(AppConfig configuration, Environment environment) {

        environment.jersey().register(new UserResource());
        environment.jersey().register(new UserViewResource());
    }
}
