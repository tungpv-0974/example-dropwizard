package com.tungpv.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Map;

@Getter
public class AppConfig extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    @JsonProperty("views")
    public Map<String, Map<String, String>> views;


}
