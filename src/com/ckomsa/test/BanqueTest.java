package com.ckomsa.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ckomsa.controller.Client;
import com.ckomsa.main.Banque;

class BanqueTest {

	@Test
	void test() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		assertNotEquals(BIDV.getTypeTransaction(), null); 
		//assertEquals(BIDV.getClient(), null); 
		// Creation des transations 
		
	}
	
	/**
	 * Test recherche 
	 */
	void test2() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		assertNotEquals(BIDV.getTypeTransaction(), null); 
		assertEquals(BIDV.getClient(), null); 
		Client client1 = new Client(BIDV, "serge1");
		Client client2 = new Client(BIDV,"landry1");
		Client client3 = new Client(BIDV, "serge2");
		Client client4 = new Client(BIDV,"landry2");
		Client client5 = new Client(BIDV, "serge3");
		Client client6 = new Client(BIDV,"landry3");
		Client client7 = new Client(BIDV, "serge4");
		Client client8 = new Client(BIDV,"landry4");
		assertEquals(BIDV.getClient(1).nomClient, "serge1");
		assertEquals(BIDV.getClient(10), null ); 
	}
}
