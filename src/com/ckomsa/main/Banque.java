/**
 * 
 */
package com.ckomsa.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;
import com.ckomsa.controller.Transaction;
import com.ckomsa.controller.TypeTransaction;
import com.ckomsa.view.Menu;

/**
 * @author sonfack
 *
 */
public class Banque {
	// liste des clients de la banque 
	private HashSet<Client> listeClient = new HashSet();
	
	// liste des types de transaction de la banque 
	 private HashSet<TypeTransaction> listeTypeTransaction = new HashSet();
	
	 
	 
	 /*
	  * Cette fonction  retourne  la liste des types transaction 
	  */
	 public HashSet<TypeTransaction> getTypeTransaction() {
		 return this.listeTypeTransaction; 
	 }
	 
	/**
	 * @return the listeTypeTransaction
	 */
	public void setListeClient(Client client) {
		Iterator<Client> iteratorClient = this.listeClient.iterator(); 
		boolean exist = false; 
		int count = 1; 
		while(iteratorClient.hasNext() && !exist) {
			if(iteratorClient.next().getIdClient() == client.getIdClient()  && 
					iteratorClient.next().nomClient.equals(client.nomClient)){
						exist = true; 
					}
			count = count +1; 
		}
		if(count < this.listeClient.size()) {
			System.out.println(client.nomClient+"existe deja et a pour identifiant"+client.getIdClient());
		}
	}

	/**
	 * @param
	 */
	public void setListeTypeTransaction(TypeTransaction typeTransaction) {
		
		this.listeTypeTransaction.add(typeTransaction);
		
	}
	
	
	/*
	 * 
	 */
	public void printListeClient() {
		for(Client clt:this.listeClient) {
			System.out.println(clt.nomClient);
		}
	}

	public void printListeTypeTransaction() {
		for(TypeTransaction trs:this.listeTypeTransaction) {
			System.out.println(trs.getTypeTransaction());
		}
	}
	
	/**
	 * Constructeur de la classe banque
	 */
	public Banque() {
		
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Banque BIDV  = new Banque();
		Menu MenuBanque = Menu.getInstanceMenu(BIDV);
		Scanner sc =new Scanner(System.in);
		int choix = sc.nextInt(); 
		while(choix != 0) {
			if(choix < 0) {
			// choix negatif 	
				
			}else {
				switch(choix) {
					case 1 : {
						MenuBanque.MenuRecherche(BIDV);	
						break; 
					}
					case 2 : {
						MenuBanque.MenuCreerCompte(BIDV);
						break;
					}
					case 3 : {
						//MenuBanque.MenuTransaction(BIDV);
						break; 
					}
					default :{
						MenuBanque.MessageErreur();
					}
				
				}
				
				System.out.print("votre choix est : ");
				choix = sc.nextInt(); 
			}
		}
		
		
		/*
		 * TypeTransaction tr1 = new TypeTransaction(BIDV, "depot"); 
		TypeTransaction tr2 = new TypeTransaction(BIDV, "retrait"); 
		BIDV.printListeTypeTransaction();
		System.out.println("/////////");
		Client clt = new Client(BIDV, "serge", 1); 
		Compte cpt = new Compte(clt, 122); 
		Compte cpt2 = new Compte(clt, 12); 
		Transaction tr = new Transaction(clt, cpt, tr1, 300.0);
		Transaction tr00 = new Transaction(clt, cpt, tr1, 600.0);
		System.out.println("/////////////////");
		System.out.println(tr.getDateTransaction().toString());
		System.out.println(tr.getMontantTransaction());
		System.out.println("/////////////////");
		System.out.println(cpt.getSolde());
		// cpt.setListeTransaction(tr);
		System.out.println(cpt.getListeTransaction().size());
		Client clt2 = new Client(BIDV, "landry", 3);
		Client clt4 = new Client(BIDV, "landry", 3);
		Client clt3 = new Client(BIDV, "sylvain", 23); 
		
		 */
		BIDV.printListeClient();
		System.out.println("Programme termine");
		System.exit(0);
	}

}
