/**
 * 
 */
package com.ckomsa.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
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
	
	 public HashSet<Client> getClient(){
		 return this.listeClient; 
	 }
	 
	 
	 /**
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
	 
	 /**
	  * recherche un client connaissant a partir de son identifiant
	  */
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
	
	/**
	 * Calcule d'interet
	 */
	public void calculateInteret() {
		if(this.listeClient.size() == 0) {
			System.out.println("---- Aucun client dans la banque ----");
		}else {
			for(Client clt:this.listeClient) {
				System.out.println("Client : "+clt.nomClient);
				for(int i = 0 ; i < clt.listeCompte.size() ; i++) {
					System.out.println("Numero de complte"+clt.listeCompte.get(i).getNumCompte());
				 	System.out.println("----Solde : "+clt.listeCompte.get(i).getSolde()+"----");
				 	clt.listeCompte.get(i).setInteret();
					//clt.listeCompte.get(i).setSolde((clt.listeCompte.get(i).getTaux()*clt.listeCompte.get(i).getSolde())/100 + clt.listeCompte.get(i).getSolde());
					System.out.println("----Nouveau solde : "+clt.listeCompte.get(i).getSolde()+"  pour Interet : "+clt.listeCompte.get(i).getTaux()+" ----");
				}
				System.out.println("----------------------------------------------------------");
			}
		}
	}
	
	/**
	 * 
	 */
	public void printListeClient() {
		for(Client clt:this.listeClient) {
			System.out.println(clt.nomClient);
		}
	}

	/**
	 * Cette fonction retourn le rapport des transation de la banque 
	 */
	public void printRapport() {
		System.out.println("##############################################"); 
		System.out.println("### Rapport  des transaction de la banque ####");
		System.out.println("##############################################");
		for(Client clt:this.listeClient) {
			System.out.println("Nom : "+clt.nomClient);
			for(int index =0 ; index< clt.listeCompte.size(); index++) {
				System.out.println("Compte NO: "+ clt.listeCompte.get(index).getNumCompte());
				System.out.println("Sole : "+clt.listeCompte.get(index).getSolde()+"Euros");
				for(int intTrs = 0 ; 
						intTrs < clt.listeCompte.get(index).getListeTransaction().size(); 
						intTrs++) {
					if(
						clt.listeCompte.get(index).getListeTransaction().
						get(intTrs).getNomTypeTransaction().equals("depot")) {
						System.out.println("---- Déposer  un montant de "+
						clt.listeCompte.get(index).getListeTransaction().get(intTrs).
						getMontantTransaction()+"Euros pour le compte "+ clt.listeCompte.
						get(index).getNumCompte()+"au "+clt.listeCompte.get(index).
						getListeTransaction().get(intTrs).getDateTransaction());
					}else if(clt.listeCompte.get(index).getListeTransaction().
							get(intTrs).getNomTypeTransaction().equals("retrait")) {
						System.out.println("---- Retirer  un montant de "+ 
							clt.listeCompte.get(index).getListeTransaction().get(intTrs).
							getMontantTransaction()+"Euros pour le compte "+ clt.listeCompte.get(index).getNumCompte()+"au "+clt.listeCompte.get(index).getListeTransaction().get(intTrs).getDateTransaction());
					}
				}
			}
			System.out.println("\n----------------------------------------\n");
		}
		
	}
	
	
	/**
	 * 
	 */
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
		try {
			Banque BIDV  = new Banque();
			boolean fin = true;
			do {
				Menu MenuBanque = Menu.getInstanceMenu(BIDV," ");
				Scanner sc =new Scanner(System.in);
				try {
					System.out.print("\n\n*Choix : ");
					int choix = sc.nextInt(); 
					if(choix < 0) {
						// choix negatif 	
						System.out.println("*Reponse : ---- Votre choix doit etre un entier positif ----");
						}else if(choix > 0) {
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
								case 5 : {
									BIDV.printRapport();
									break ; 
								}
								case 6 : {
									MenuBanque.menuRecherche(BIDV); 
									break; 
								}
								default :{
									MenuBanque.messageErreur();
								}
							
							}
							
							//MenuBanque = Menu.getInstanceMenu(BIDV, " ");
							//choix = sc.nextInt(); 
						}else if(choix == 0) {
							fin = false; 
						}
				}catch(InputMismatchException e) {
					System.out.println("*Reponse : ---- Votre choix doit etre un entier en 0 et 6, verifiez le menu et entrez a nouveau ----");
				}
			
			}while(fin);
			BIDV.printListeClient();
		}catch(Error e) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$  Une erreur grave est survenue : " + e+" $$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
		
		System.out.println("Programme termine");
		System.exit(0);
			
		 /*try {
			
			
			
			while(choix != 0) {
				
			}
			BIDV.printListeClient();
			System.out.println("Programme termine");
			System.exit(0);
		}catch(InputMismatchException e) {
			System.out.println("---- Votre choix doit etre un entier ----");
		}
	
		
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
		
	}

}
