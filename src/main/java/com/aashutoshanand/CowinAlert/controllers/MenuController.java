package com.aashutoshanand.CowinAlert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aashutoshanand.CowinAlert.service.AlertOrchestrationService;

@RestController
public class MenuController {
	
	@Autowired
	AlertOrchestrationService alertOrchestrationService;
	
	@GetMapping(value="{pincode}/{date}/getAppointment")
	public void viewSlots(@PathVariable("pincode") String pincode, @PathVariable("date") String date) {
		try {
			alertOrchestrationService.checkSlots(pincode,date);
		}catch(Exception e) {
			
		}
	}
}
