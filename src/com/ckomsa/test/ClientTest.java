/**
 * 
 */
package com.ckomsa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ckomsa.controller.Client;
import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
class ClientTest {

	@Test
	void test() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		Banque SeaD = new Banque(); 
		assertNotNull("Non null", SeaD);
		/*
		 * Deux clients différentes de la meme banque sont différentes 
		 */
		Client client1 = new Client(BIDV, "serge", 1);
		Client client2 = new Client(BIDV,"landry",1);
		assertNotNull("Not null test",client1); 
		assertNotNull("Not null test",client2); 
		assertEquals(client1.nomClient, client2.nomClient); 
		assertEquals(client1.getIdClient(), client2.getIdClient());
		/*
		 * un client peut etre dans plusieur Banque
		 */
		Client client3 = new Client(SeaD, "serge", 1); 
		
		System.out.println("test");
	}

}
