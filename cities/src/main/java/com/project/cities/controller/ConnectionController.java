package com.project.cities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cities.service.ConnectionService;

@RestController
public class ConnectionController {
	
@Autowired	
ConnectionService connService;	
	

	public static final String YES = "yes";
	public static final String NO = "no";

	@RequestMapping("/connected")
	public String isConnected(@RequestParam(defaultValue = "") String origin, @RequestParam(defaultValue = "") String destination) {
	
		String fileName = "cities.txt";
		boolean isConnected = connService.isConnected(origin, destination, fileName);
		return isConnected?YES:NO;
	}
}
