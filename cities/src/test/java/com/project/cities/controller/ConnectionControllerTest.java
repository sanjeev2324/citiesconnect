package com.project.cities.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;

import com.project.cities.service.ConnectionService;


class ConnectionControllerTest {

/*	@Value("${fileName}")
	private String fileName;*/
	
	String fileName = "cities.txt";
	
	@Test
	void testIsConnected_NO() {
		
		ConnectionService connService =   mock(ConnectionService.class);
	    when(connService.isConnected("Boston", "Atlanta", fileName)).thenReturn(false);
	    ConnectionController connController = new ConnectionController();
		
	    //Using RefelctionUtils by Spring to inject the mocked value into this context
	    ReflectionTestUtils.setField(connController, "connService", connService); 
		assertEquals("no",connController.isConnected("Boston", "Atlanta"));
	}
	
	
	@Test
	void testIsConnected_YES() {

		ConnectionService connService =   mock(ConnectionService.class);
	    when(connService.isConnected("Miami", "Atlanta", fileName)).thenReturn(true);
	    ConnectionController connController = new ConnectionController();
		
	    //Using RefelctionUtils by Spring to inject the mocked value into this context
	    ReflectionTestUtils.setField(connController, "connService", connService); 
		assertEquals("yes",connController.isConnected("Miami", "Atlanta"));
	}

	//Passing null values as city 
	@Test
	void testIsConnected_NULL() {
		
		ConnectionService connService =   mock(ConnectionService.class);
	    when(connService.isConnected(null, null,fileName)).thenReturn(false);
	    ConnectionController connController = new ConnectionController();
		
	    //Using RefelctionUtils by Spring to inject the mocked value into this context
	    ReflectionTestUtils.setField(connController, "connService", connService); 
		assertEquals("no",connController.isConnected(null, null));
	}
	
	//Passing blank values as city 
	@Test
	void testIsConnected_BLANK() {
		
		ConnectionService connService =   mock(ConnectionService.class);
	    when(connService.isConnected("", "", fileName)).thenReturn(false);
	    ConnectionController connController = new ConnectionController();
		
	    //Using RefelctionUtils by Spring to inject the mocked value into this context
	    ReflectionTestUtils.setField(connController, "connService", connService); 
		assertEquals("no",connController.isConnected("", ""));
	}
	
	
}
