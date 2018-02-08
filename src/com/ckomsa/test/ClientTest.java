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
		// Deux clients différentes de la meme banque sont différentes 
		Client client1 = new Client(BIDV, "serge");
		Client client2 = new Client(BIDV,"landry");
		assertNotNull("Not null test",client1); 
		assertNotNull("Not null test",client2); 
		assertNotEquals(client1.nomClient, client2.nomClient); 
		assertNotEquals(client1.getIdClient(), client2.getIdClient());
		assertNotEquals(client1.nomClient, client2.nomClient); 
		assertNotEquals(client1.getIdClient(), client2.getIdClient());
		System.out.println("Fin test");
	}

}
