package com.gsp.bridge;

import com.gsp.bridge.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties(value = {JwtProperties.class})
@EnableJpaAuditing
@SpringBootApplication
public class BridgeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BridgeServerApplication.class, args);
    }

}
