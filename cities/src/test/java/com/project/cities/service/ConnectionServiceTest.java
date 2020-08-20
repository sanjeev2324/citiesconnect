package com.project.cities.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ConnectionServiceTest {

	
	ConnectionService conn = new ConnectionService();
	String fileName = "cities.txt";
	
	@Test
	public void isConnected_True() {
	boolean retVal = conn.isConnected("Trenton", "Pittsburgh", fileName);
	assertTrue(retVal);
	}

	
	@Test
	public void isConnected_False() {
	boolean retVal = conn.isConnected("Trenton", "Miami", fileName);
	assertFalse(retVal);
	}
	
	
	@Test
	public void isConnected_WRONGVALUES() {
	boolean retVal = conn.isConnected("@#!@", "12121", fileName);
	assertFalse(retVal);
	}
	
	@Test
	public void isConnected_SAMEVALUE() {
	boolean retVal = conn.isConnected("Trenton", "Trenton", fileName);
	assertFalse(retVal);
	}
	
	@Test
	public void isConnected_SameValue_UNDEFINED() {
	boolean retVal = conn.isConnected("London", "London", fileName);
	assertFalse(retVal);
	}
	
	@Test
	public void isConnected_SameValue_BLANK() {
	boolean retVal = conn.isConnected("", "", fileName);
	assertFalse(retVal);
	}
	
	
	@Test
	public void processEachLine_SINGLEVALUE() {
	conn.processEachLine("Denver");
	}
	
	@Test
	public void processEachLine_NormalValues() {
	conn.processEachLine("Denver, Austin");
	}
	
	
}
