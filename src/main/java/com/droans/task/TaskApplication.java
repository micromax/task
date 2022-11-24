package com.droans.task;

import com.droans.task.domain.Drons;
import com.droans.task.domain.Medication;
import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;
import com.droans.task.service.DroansService;
import com.droans.task.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TaskApplication {




	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}



}
