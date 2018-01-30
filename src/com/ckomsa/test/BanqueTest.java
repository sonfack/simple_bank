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
		/*
		 * un client ne doit pas avoir plusieur compte dans la meme banque 
		 */
		Client clt2 = new Client(BIDV, "landry", 3);
		Client clt4 = new Client(BIDV, "landry", 3);
		
	}

}
