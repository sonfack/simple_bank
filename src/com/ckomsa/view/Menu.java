package com.ckomsa.view;

import java.io.IOException;
import java.util.Scanner;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;
import com.ckomsa.controller.Transaction;
import com.ckomsa.controller.TypeTransaction;
import com.ckomsa.main.Banque;

public class Menu {
	
	private static Menu menuInstance = null ; 
	
	protected  Menu(Banque banque) {
		// TODO Auto-generated constructor stub
		this.ClearScreen();
		System.out.println("########## Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour consulter un solde "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 3 pour nouvelle transaction"); 
		System.out.println("#### Entrez 4 pour calculer l'interet"); 
		System.out.println("#### 0 pour sortir de l'application ####");
		Menu.menuInstance = this;
	}
	
	protected void mainMenu(String message) {
		this.ClearScreen();
		System.out.println("---------------------------------------------------------");
		System.out.println(message);
		System.out.println("---------------------------------------------------------");
		System.out.println("########## Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour consulter un solde "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 3 pour nouvelle transaction"); 
		System.out.println("#### Entrez 4 pour calculer l'interet");
		System.out.println("#### 0 pour sortir de l'application ####");
	}
	
	public static  Menu getInstanceMenu(Banque banque, String message) {
		if(menuInstance == null) {
			menuInstance = new Menu(banque); 
		}else {
			menuInstance.mainMenu(message);
		}
		return menuInstance; 
	}
	
	public static void ClearScreen() {  
		try {
			java.lang.Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	
	public void menuConsulteSolde(Banque banque) {
		this.ClearScreen();
		System.out.println("Menu consulter solder"); 
		System.out.print("Entrez l'identifiant du client: ");	
		//System.out.println("#### 0 pour sortir de l'application ####");
		Scanner donnee =new Scanner(System.in);
		int idClient = donnee.nextInt();
		Client client =  banque.getClient(idClient); 
		if(client != null) {
			System.out.print("Entrez numero du compte: ");
			int numCompte = donnee.nextInt();
			Compte compte = client.getCompte(numCompte); 
			if(compte != null) {
				System.out.println("----Le solde est de "+compte.getSolde()+"----");
			}else {
				String message  = "---Ce compte n'existe pas----"; 
				Menu.getInstanceMenu(banque, message);
			}
		}else {
			String message  = "---Ce client n'existe pas----"; 
			Menu.getInstanceMenu(banque, message);
		}
	}
	
	
	public void menuCalculateInteret(Banque banque) {
		banque.calculateInteret();
	}
	
	
	
	public void menuCreerCompte(Banque banque) {
		this.ClearScreen();
		Scanner donnee =new Scanner(System.in);
		String nom ; 
		int idClient ;
		int idCompte; 
		int taux ; 
		Client client1; 
		Compte compte ; 
		System.out.println("Menu Creer compte");
		System.out.print("Entrer le nom :  "); 
		nom = donnee.nextLine();
		System.out.println(" ");
		System.out.print("Entrer l'identifiant : ");
		idClient = donnee.nextInt(); 
		System.out.println(" ");
		System.out.print("Entrer l'identifiant du compte : ");
		idCompte = donnee.nextInt(); 
		System.out.println(" ");
		System.out.print("Entrez le taux : ");
		taux = donnee.nextInt(); 
		client1 =  new Client(banque, nom, idClient);
		compte = new Compte(client1, idCompte, taux); 
		client1.printCompteClient();
		this.menuTransaction(banque, client1, compte);
	}
	
	
	public void menuTransaction(Banque banque) {
		Scanner sc =new Scanner(System.in);
		int idClient ;
		String message ; 
		System.out.println("###### Menu Transaction - Entrez votre choix ######");
		System.out.print("Entrez l'identifiant du client :");
		idClient = sc.nextInt();
		Client client = banque.getClient(idClient);
		if( client != null) {
			System.out.print("Entrez le numero de compte : ");
			int numCompte ; 
			numCompte = sc.nextInt(); 
			Compte compte = client.getCompte(numCompte); 
			if(compte != null) {
				this.menuTransaction(banque,client, compte);
			}else {
				message = " Le compte de numero "+numCompte+"n'existe pas"; 
				this.mainMenu(message);
			}
		}else {
			message = "Le client d'Id "+idClient+" n'existe pas"; 
			this.mainMenu(message);
		}
		
	}
	
	public void menuTransaction(Banque banque, Client client , Compte compte) {
		this.ClearScreen();
		Scanner sc =new Scanner(System.in);
		int choix ;
		double montant ;
		String nomTypeTransaction ; 
		TypeTransaction typeTransaction ;
		//int choix = sc.nextInt(); 
		System.out.println("###### Menu Transaction - Entrez votre choix ######");
		System.out.println("Entrez 1 pour depot  "); 
		System.out.println("Entrez 2 pour retrait");	
		System.out.println("#### 0 pour sortir du menu ####");
		choix = sc.nextInt();
		switch(choix) {
			case 1 : {
			
				nomTypeTransaction = "depot";
				typeTransaction = banque.getTypeTransaction(nomTypeTransaction); 
				System.out.print("Entrez montant du depot: ");
				montant =  sc.nextDouble() ;
				Transaction transaction =  new Transaction(client, compte,typeTransaction,montant );
				compte.printListeTransaction();
				break; 
			}
			case 2 : {
				nomTypeTransaction = "retrait";
				typeTransaction = banque.getTypeTransaction(nomTypeTransaction); 
				System.out.print("Entrez montant du retrait : ");
				montant =  sc.nextDouble() ;
				Transaction transaction =  new Transaction(client, compte,typeTransaction,montant );
				compte.printListeTransaction();
				break ; 
			}
			default: {
				this.messageErreur();
			}
		}
	}
	
	
	public void messageErreur() {
		this.ClearScreen();
		System.out.println("Votre choix n est pas bon");
	}
}
