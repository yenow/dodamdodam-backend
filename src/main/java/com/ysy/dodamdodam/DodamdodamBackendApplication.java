package com.ysy.dodamdodam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ServletComponentScan
@EnableJpaAuditing
public class DodamdodamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DodamdodamBackendApplication.class, args);
    }

}
