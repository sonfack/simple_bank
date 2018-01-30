/**
 * 
 */
package com.ckomsa.test;

import org.junit.FixMethodOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;

/**
 * @author sonfack
 * miniscule tous les type de transaction 
 * NB: pas deux type de transaction portant le meme nom
 * chaque compte doit avoir un type de transation 
 * 
 *
 */
@FixMethodOrder()
class CompteTest {

	@Test
	void test0() {
		Client client1 = new Client("serge", 1);
		Compte cpt1 = new Compte(client1, 1); 
		assertNotNull("Not null", cpt1); 
		assertEquals(client1.nomClient, cpt1.nomClient); 
		assertEquals(client1.GetIdClient(), cpt1.GetIdClient());
		assertEquals(cpt1.GetSolde(), 0, 0.001);
		assertEquals(cpt1.GetTaux(), 0, 0.001);
		////////////////////////////////////////////////////////
		client1.SetNomClient("Landry");
		assertEquals(client1.nomClient, cpt1.nomClient);
		System.out.println("test0");
	}
	
	@Test
	void test1() {
		Client client1 = new Client("serge", 1);
		Compte cpt1 = new Compte(client1, 1); 
		assertNotNull("Not null", cpt1); 
		assertEquals(client1.nomClient, cpt1.nomClient); 
		assertEquals(client1.GetIdClient(), cpt1.GetIdClient());
		assertEquals(cpt1.GetSolde(), 0, 0.001);
		assertEquals(cpt1.GetTaux(), 0, 0.001); 
		System.out.println("test1");
	}
	

}
