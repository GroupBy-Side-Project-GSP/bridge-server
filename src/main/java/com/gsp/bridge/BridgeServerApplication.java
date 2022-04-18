package com.gsp.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BridgeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BridgeServerApplication.class, args);
    }

}
