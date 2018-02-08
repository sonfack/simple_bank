/**
 * 
 */
package com.ckomsa.test;

import org.junit.FixMethodOrder;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;
import com.ckomsa.controller.Transaction;
import com.ckomsa.controller.TypeTransaction;
import com.ckomsa.main.Banque;

/**
 * @author sonfack
 * miniscule tous les type de transaction 
 * NB: pas deux type de transaction portant le meme nom
 * chaque compte doit avoir un type de transation 
 * 
 */
@FixMethodOrder()
class CompteTest {

	/**
	 * Test de compte
	 */
	@Test
	void test0() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		Client client1 = new Client(BIDV, "serge");
		Client client2 = new Client(BIDV,"landry");
		Compte cpt1 = new Compte(client1, 3); 
		Compte cpt2 = new Compte(client2, 4);
		assertNotNull("Not null", cpt1); 
		assertNotNull("Not null", cpt2);
		assertEquals(cpt1.getTaux(), 3); 
		assertEquals(cpt2.getTaux(), 4);  
		System.out.println("Fin test0");
	}
	
	/**
	 * Test interet
	 */
	
	void test1() {
		Banque BIDV = new Banque(); 
		assertNotNull("Non null", BIDV);
		Client client1 = new Client(BIDV, "serge");
		Compte cpt1 = new Compte(client1, 2);
		cpt1.setInteret();
		assertEquals(cpt1.getSolde(), 0.0,0); 
		// type transaction
		TypeTransaction typeTrs1 = new TypeTransaction(BIDV,"depot"); 
		TypeTransaction typeTrs2 = new TypeTransaction(BIDV,"retrait"); 
		// transaction 
		Transaction Trs1 = new Transaction(client1, cpt1, typeTrs1, 500); 
		Transaction Trs2 = new Transaction(client1, cpt1, typeTrs2, 200);
		//consultation
		assertEquals(cpt1.getSolde(), 300,0);
		cpt1.setInteret();
		double intCal = (300.0*2.0)/100.0 + 300.0; 
		assertEquals(cpt1.getSolde(), intCal,0); 
		
	}
	
}
