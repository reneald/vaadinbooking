package com.switchfully.vaadin.lesson_01.grids;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.switchfully.vaadin.lesson_01.grids",
        "com.switchfully.vaadin.service"
})
public class Application_Lesson01_Grids {

    public static void main(String[] args) {
        SpringApplication.run(Application_Lesson01_Grids.class);
    }

}