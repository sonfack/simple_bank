package com.ckomsa.view;

import java.io.IOException;
import java.util.InputMismatchException;
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
		System.out.println("########### Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour consulter un solde "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 3 pour nouvelle transaction"); 
		System.out.println("#### Entrez 4 pour calculer l'interet"); 
		System.out.println("#### Entrez 5 pour produit le raport"); 
		System.out.println("#### Entrez 6 pour effectuer une recherche"); 
		System.out.println("########### 0 pour sortir de l'application      ############");
		Menu.menuInstance = this;
	}
	
	protected void mainMenu(String message) {
		this.ClearScreen();
		System.out.println("---------------------------------------------------------");
		System.out.println(message);
		System.out.println("---------------------------------------------------------");
		System.out.println("########### Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour consulter un solde "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 3 pour nouvelle transaction"); 
		System.out.println("#### Entrez 4 pour calculer l'interet");
		System.out.println("#### Entrez 5 pour produit le raport"); 
		System.out.println("#### Entrez 6 pour effectuer une recherche"); 
		System.out.println("########### 0 pour sortir de l'application      ##########");
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
		System.out.println("\n\n");
	}  
	
	public void menuConsulteSolde(Banque banque) {
		if( !banque.getClient().isEmpty()) {
			try {
				System.out.println("Menu consulter solder"); 
				System.out.print("Entrez l'identifiant du client: ");	
				//System.out.println("#### 0 pour sortir de l'application ####");
				Scanner donnee =new Scanner(System.in);
				int idClient = donnee.nextInt();
				if(idClient > Integer.MAX_VALUE) {
					 throw new RuntimeException("---- Valeur entree pas correcte ----");
				}else if(idClient < Integer.MIN_VALUE || idClient <= 0) {
					throw new RuntimeException("---- Valeur entree pas correcte ----");
				}
				Client client =  banque.getClient(idClient); 
				if(client != null) {
					System.out.print("Entrez numero du compte: ");
					try {
						int numCompte = donnee.nextInt();
						if(numCompte > Integer.MAX_VALUE) {
							 throw new RuntimeException("---- Valeur entree pas correcte ----");
						}else if(numCompte < Integer.MIN_VALUE || numCompte <=0) {
							throw new RuntimeException("---- Valeur entree pas correcte ----");
						}
						Compte compte = client.getCompte(numCompte); 
						if(compte != null) {
							System.out.println("----Solde : "+compte.getSolde()+" client : "+client.nomClient+" ----");
						}else {
							String message  = "---- Compte n'existe pas ----"; 
							System.out.print(message);
							//mainMenu(message);
						}
					}catch(InputMismatchException e) {
						donnee.nextLine() ; 
						System.out.println("---- Numero compte doit etre entier ----");
					}
					
				}else {
					String message  = "----Client n'existe pas ----"; 
					System.out.print(message);
					//mainMenu(message);
				}
			}catch(InputMismatchException e) {
				String message  = "----Client n'existe pas ----"; 
			}
		}else {
			System.out.println("*Reponse : ---- Aucun client dans la banque ----");
		}
		
	}
	
	
	public void menuRecherche(Banque banque) {
		System.out.println("\nMenu recherche client\n");
		Scanner donnee = new Scanner(System.in); 
		int idClient ; 
		Client client ;
		try {	
			System.out.print("*Identifiant client : ");
			idClient = donnee.nextInt(); 
			if(idClient > Integer.MAX_VALUE) {
				 throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}else if(idClient < Integer.MIN_VALUE) {
				throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}else if(idClient < 0) {
				System.out.println("*Reponses : ----  L'identifiant du client doit etre en entier positif ----");
				this.menuRecherche(banque);
			}else if(idClient < 0) {
				System.out.println("*Reponses : ---- Valeur entree doit etre positive ----");
				this.menuRecherche(banque);
			}
			client = banque.getClient(idClient); 
			if(client != null) {
				client.printCompteClient();
			}else {
				System.out.println("*Reponses : ---- Aucun client pour cet identifiant ----");
			}
		}catch(InputMismatchException e) {
			System.out.println("*Reponses : ---- L'identifiant du client doit etre en entier ----");
			this.menuRecherche(banque); 
		}
	}
	
	
	public void menuCalculateInteret(Banque banque) {
		banque.calculateInteret();
	}
	
	
	
	public void subMenuCreerNouveauClientCompte(Banque banque) {
		this.ClearScreen();
		Scanner donnee =new Scanner(System.in);
		String nom ; 
		int idClient ;
		int idCompte; 
		int taux ; 
		Client client1; 
		Compte compte ; 
		
		try {
			System.out.println("\nMenu Creer nouveau client et compte\n");
			System.out.print("Entrer le nom :  "); 
			nom = donnee.nextLine();
			System.out.println(" ");
			System.out.print("Entrez le taux : ");
			try {	
				taux = donnee.nextInt(); 
//				if(taux > Integer.MAX_VALUE) {
//					 throw new RuntimeException("---- Valeur entree pas correcte ----");
//				}else if(taux < Integer.MIN_VALUE || taux <=0) {
//					throw new RuntimeException("---- Valeur entree pas correcte ----");
//				}
				client1 =  new Client(banque, nom);
				compte = new Compte(client1, taux); 
				// client1.printCompteClient();
				this.menuTransaction(banque, client1, compte);
			}catch(InputMismatchException e) {
				System.out.println("*Reponses : ---- Taux doit etre un entier ----");
			}
			
		}catch(InputMismatchException e) {
			System.out.println("*Reponses : ---- Nom doit etre une chaine ----");
		}
		
	}
	
	public void subMenuCreerNouveauCompte(Banque banque) {
		System.out.println("\nMenu Creer compte client existant\n");
		Scanner donnee =new Scanner(System.in);
		int idClient ; 
		int taux;
		Compte compte ; 
		Client client1; 
		try {
			System.out.print("Entrer l'identifiant client : ");
			idClient = donnee.nextInt();  
			if(idClient > Integer.MAX_VALUE) {
				 throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}else if(idClient < Integer.MIN_VALUE) {
				throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}else if(idClient < 0) {
				System.out.println("*Reponses : ---- Valeur entree doit etre positive ----");
				this.subMenuCreerNouveauCompte(banque);
			}
			client1 = banque.getClient(idClient);
			if(client1 != null) {
				System.out.println(" ");
				System.out.print("Entrez le taux : ");
				taux = donnee.nextInt();
				if(taux > Integer.MAX_VALUE) {
					 throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
				}else if(taux < Integer.MIN_VALUE) {
					throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
				}else if(taux < 0) {
					System.out.println("*Reponses : ---- Valeur entree doit etre positive ----");
					this.subMenuCreerNouveauCompte(banque);
				}
				compte = new Compte(client1, taux); 
				client1.printCompteClient();
				this.menuTransaction(banque, client1, compte);
			}else {
				System.out.println("*Reponses : ---- Client n'existe pas ----");
			}
			
		}catch(InputMismatchException e) {
			System.out.println("*Reponses : ---- Identifiant client doivent etre un entier ----");
			this.subMenuCreerNouveauCompte(banque);
		}
	}
	
	public void menuCreerCompte(Banque banque) {
		this.ClearScreen();
		System.out.println("###### Sous Menu Creer Compte - Entrez votre choix ######");
		System.out.println("###### Entrez 1 pour nouveau client");
		System.out.println("###### Entrez 2 pour client existant");
		System.out.println("###### Entrez 0 pour compte existant");
		System.out.print("\n*Choix : ");
		Scanner sc = new Scanner(System.in); 
		int choix ;
		try {
			choix = sc.nextInt();

			if(choix > Integer.MAX_VALUE) {
				 throw new RuntimeException("*Reponse : ---- Valeur entree incorrecte ----\n**Reponse : ---- Votre choix doit etre un entier en 0 et 2, verifiez le menu et entrez a nouveau ----");
			}else if(choix < Integer.MIN_VALUE) {
				throw new RuntimeException("*Reponse : ---- Valeur entree incorrecte ----\n**Reponse : ---- Votre choix doit etre un entier en 0 et 2, verifiez le menu et entrez a nouveau ----");
			}else if(choix < 0) {
				System.out.print("*Reponse : ---- Valeur entree incorrecte ----\n**Reponse : ---- Votre choix doit etre un entier en 0 et 2, verifiez le menu et entrez a nouveau ----");
				this.menuCreerCompte(banque);
			}
			switch(choix) {
				case 1 : {
					this.subMenuCreerNouveauClientCompte(banque);
					break ; 
				}
				case 2 : {
					this.subMenuCreerNouveauCompte(banque);
					break; 
				}
				case 0 : {
					System.out.print("*Reponse : ---- Retour au menu principal ----");
					break; 
				}
				default: {
					this.messageErreur();
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("*Reponse : ---- Votre choix doit etre un entier en 0 et 2, verifiez le menu et entrez a nouveau ----");
			this.menuCreerCompte(banque);
		}
		
	}
	
	public void menuTransaction(Banque banque) {
		Scanner sc =new Scanner(System.in);
		int idClient ;
		String message ; 
		try {
			System.out.println("###### Menu Transaction - Entrez votre choix ######");
			System.out.print("\nEntrez l'identifiant du client :");
			idClient = sc.nextInt();
			if(idClient > Integer.MAX_VALUE) {
				 throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}else if(idClient < Integer.MIN_VALUE) {
				throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
			}
			Client client = banque.getClient(idClient);
			if( client != null) {
				client.printCompteClient();
				System.out.print("\nEntrez le numero de compte : ");
				int numCompte ; 
				numCompte = sc.nextInt(); 
				if(numCompte > Integer.MAX_VALUE) {
					 throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
				}else if(numCompte < Integer.MIN_VALUE) {
					throw new RuntimeException("*Reponses : ---- Valeur entree pas correcte ----");
				}
				Compte compte = client.getCompte(numCompte); 
				if(compte != null) {
					this.menuTransaction(banque,client, compte);
				}else {
					System.out.println("*Reponses : ---- Compte numero "+numCompte+" n'existe pas ----"); 
					// this.mainMenu(message);
				}
			}else {
				System.out.println("*Reponse :  ---- Client d'indentifiant "+idClient+" n'existe pas ----");
				// this.mainMenu(message);
			}
			
		}catch(InputMismatchException e) {
			System.out.println("*Reponses : ---- Identifiant client et numero compte aux doivent etre un entier ----");
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
		if(compte.getSolde() != 0.0) {
			System.out.println("Entrez 2 pour retrait");
		}
		System.out.println("#### 0 pour sortir du menu ####");
		System.out.print("*choix : ");
		choix = sc.nextInt();
		if(choix > Integer.MAX_VALUE) {
			 throw new RuntimeException("---- Valeur entree pas correcte ----");
		}else if(choix < Integer.MIN_VALUE) {
			throw new RuntimeException("---- Valeur entree pas correcte ----");
		}
		switch(choix) {
			case 1 : {
				try {
					nomTypeTransaction = "depot";
					typeTransaction = banque.getTypeTransaction(nomTypeTransaction); 
					System.out.print("Entrez montant du depot: ");
					montant =  sc.nextDouble() ;
					if(montant > Double.MAX_VALUE ) {
						 throw new RuntimeException("---- Valeur entree pas correcte ----");
					}else if(montant < Double.MIN_VALUE || montant < 0) {
						throw new RuntimeException("---- Valeur entree pas correcte ----");
					}
					Transaction transaction =  new Transaction(client, compte,typeTransaction,montant );
				}catch(InputMismatchException e) {
					System.out.println("---- Montant depot etre un nombre ----");
				}
				break; 
			}
			case 2 : {
				if(compte.getSolde() == 0) {
					System.out.println("*Reponses : ---- Choix doit etre entre 0 et 1 ----"); 
				}else {
					try {
						nomTypeTransaction = "retrait";
						typeTransaction = banque.getTypeTransaction(nomTypeTransaction); 
						System.out.print("Entrez montant du retrait : ");
						montant =  sc.nextDouble() ;
						if(montant > Double.MAX_VALUE) {
							 throw new RuntimeException("---- Valeur entree pas correcte ----");
						}else if(montant < Double.MIN_VALUE || montant <= 0) {
							throw new RuntimeException("---- Valeur entree pas correcte ----");
						}
						if(compte.getSolde() < montant ) {
							System.out.println("---- Solde  insuffisant ---");
						}else {
							Transaction transaction =  new Transaction(client, compte,typeTransaction,montant );
						}
						}catch(InputMismatchException e) {
							System.out.println("---- Montant depot etre un nombre ----");
					}
				}
				break ; 
			}
			default: {
				this.messageErreur();
			}
		}
	}
	
	
	public void messageErreur() {
		System.out.print("*Reponse: ---- Votre choix n est pas bon, verifiez le menu et entrez a nouveau ----");
	}
}
