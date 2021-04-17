package com.cyp.gitnewmodulewhole.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:config/timer.properties")
@ConfigurationProperties(prefix = "schedule.timer")
public class ConfigUtil {
private String cronfives;

    public String getCronfives() {
        return cronfives;
    }

    public void setCronfives(String cronfives) {
        this.cronfives = cronfives;
    }
}

