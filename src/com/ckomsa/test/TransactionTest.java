/**
 * 
 */
package com.ckomsa.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;
import com.ckomsa.controller.Transaction;
import com.ckomsa.controller.TypeTransaction;
import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
class TransactionTest {

	@Test
	void test() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		Client client1 = new Client(BIDV, "serge");
		Client client2 = new Client(BIDV,"landry");
		Compte cpt1 = new Compte(client1, 3); 
		Compte cpt2 = new Compte(client2, 4);
		// type transaction
		TypeTransaction typeTrs1 = new TypeTransaction(BIDV,"depot"); 
		TypeTransaction typeTrs2 = new TypeTransaction(BIDV,"retrait"); 
		// transaction 
		Transaction Trs1 = new Transaction(client1, cpt1, typeTrs1, 500); 
		Transaction Trs2 = new Transaction(client1, cpt1, typeTrs1, -100);
		Transaction Trs4 = new Transaction(client1, cpt1, typeTrs1, 0); 
		Transaction Trs5 = new Transaction(client1, cpt1, typeTrs2, 200); 
		assertEquals(cpt1.getSolde(), 300); 
	}

}
