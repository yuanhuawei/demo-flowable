package com.example.demo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.TaskService;
import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessEngine processEngine;

    @RequestMapping("/")
    public String index() {
        System.out.println("------------taskService:>>>>>>" + taskService);
        System.out.println("------------processEngine:>>>>>>" + processEngine);
        return "Hello world";
    }

    public static void main(String[] args) {
        logger.info("应用启动----------------------------");
        SpringApplication.run(DemoApplication.class, args);
    }
}
