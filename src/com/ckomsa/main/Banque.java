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
	 
	 public TypeTransaction getTypeTransaction(String nomTypeTransaction) {
		 TypeTransaction type = null;
		 for(TypeTransaction trs:this.listeTypeTransaction) {
				if(trs.getTypeTransaction().equals(nomTypeTransaction)) {
					type = trs;
				}
			}
		 return type; 
	 }
	 
	 public Client getClient(int idClient) {
		 Client client = null ; 
		 for(Client clt:this.listeClient) {
			 if(clt.getIdClient() == idClient) {
				 client = clt; 
			 }
		 }
		
		 return client;
	 }
	 
	/**
	 * @return the listeTypeTransaction
	 */
	public void setListeClient(Client client) {
		int count = 0; 
		for(Client clt:this.listeClient) {
			if(clt.getIdClient() != client.getIdClient()) {
				count ++; 
			}
		}
		if(count >= this.listeClient.size()) {
			this.listeClient.add(client); 
		}
	}

	/**
	 * @param
	 */
	public void setListeTypeTransaction(TypeTransaction typeTransaction) {
		
		this.listeTypeTransaction.add(typeTransaction);
		
	}
	
	/*
	 * Calcul d'interet
	 */
	public void calculateInteret() {
		 for(Client clt:this.listeClient) {
			 System.out.println("Client : "+clt.nomClient);
			 for(int i = 0 ; i < clt.listeCompte.size() ; i++) {
				 	System.out.println("Numero de complte"+clt.listeCompte.get(i).getNumCompte());
				 	System.out.println("----Solde : "+clt.listeCompte.get(i).getSolde()+"----");
					clt.listeCompte.get(i).setSolde((clt.listeCompte.get(i).getTaux()*clt.listeCompte.get(i).getSolde())/100 + clt.listeCompte.get(i).getSolde());
					System.out.println("----Nouveau solde : "+clt.listeCompte.get(i).getSolde()+"  pour Interet : "+clt.listeCompte.get(i).getTaux()+" ----");
			 }
			 System.out.println("----------------------------------------------------------");
		 }
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
		TypeTransaction typetransaction1 = new TypeTransaction(this, "depot");
		TypeTransaction typetransaction2 = new TypeTransaction(this, "retrait");	
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TypeTransaction  typeTransaction  = 
		//System.out.println(BIDV.getTypeTransaction("depot").getTypeTransaction());
		
		
	
		//BIDV.printListeClient();
		//BIDV.getClient(1);
		/*
		 * Client clt = new Client(BIDV, "serge0", 1);
		Client clt1 = new Client(BIDV, "serge1", 1);
		Client clt2 = new Client(BIDV, "serge2", 6);
		Client clt3 = new Client(BIDV, "serge3", 5);
		Client clt4 = new Client(BIDV, "serge4", 2);
		Client clt5 = new Client(BIDV, "serge5", 3);
		Client clt6 = new Client(BIDV, "serge6", 4);
		Compte cpt = new Compte(clt, 122); 
		System.out.println("///////////////////////////");
		 */ 
		Banque BIDV  = new Banque();
		Menu MenuBanque = Menu.getInstanceMenu(BIDV," ");
		Scanner sc =new Scanner(System.in);
		int choix = sc.nextInt(); 
		while(choix != 0) {
			if(choix < 0) {
			// choix negatif 	
				
			}else {
				switch(choix) {
					case 1 : {
						MenuBanque.menuConsulteSolde(BIDV);	
						break; 
					}
					case 2 : {
						MenuBanque.menuCreerCompte(BIDV);
						break;
					}
					case 3 : {
						MenuBanque.menuTransaction(BIDV);
						break; 
					}
					case 4 : {
						MenuBanque.menuCalculateInteret(BIDV);
						break; 
					}
					default :{
						MenuBanque.messageErreur();
					}
				
				}
				
				MenuBanque = Menu.getInstanceMenu(BIDV, " ");
				choix = sc.nextInt(); 
			}
		}
		
		
	
		 /*
		  * * TypeTransaction tr1 = new TypeTransaction(BIDV, "depot"); 
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
