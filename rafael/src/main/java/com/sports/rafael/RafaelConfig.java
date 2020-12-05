package com.sports.rafael;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rafael.security.oauth2")
@Data
public class RafaelConfig {
    private String clientId;
    private String clientSecret;
    private String authzUrl;
}
