package com.web.project;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.web.project.controller.WebController;


@SpringBootApplication
@ComponentScan(basePackages= {"com.web.project","controller"})
public class ProjectApplication {

	public static void main(String[] args) {
		new File(WebController.uploadDirectory).mkdir();
		new File(WebController.uploadDirectory2).mkdir();
		new File(WebController.uploadDirectory3).mkdir();
		new File(WebController.uploadDirectory4).mkdir();
		SpringApplication.run(ProjectApplication.class, args);
	}

}
