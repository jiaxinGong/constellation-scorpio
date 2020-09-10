package com.jiaxin.constellation.scorpio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 15307
 */
@SpringBootApplication
@PropertySource("classpath:application-dev.properties")
public class ConstellationScorpioApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConstellationScorpioApplication.class, args);
    }
}
