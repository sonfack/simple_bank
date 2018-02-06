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
		System.out.println("########## Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour consulter un solde "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 3 pour nouvelle transaction"); 
		System.out.println("#### Entrez 4 pour calculer l'interet"); 
		System.out.println("#### Entrez 5 pour produit le raport"); 
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
		System.out.println("#### Entrez 5 pour produit le raport"); 
		System.out.println("#### 0 pour sortir de l'application ####");
	}
	
	public void menuRapport(Banque banque) {
		
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
			System.out.println("---- Aucun client dans la banque ----");
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
				client1.printCompteClient();
				this.menuTransaction(banque, client1, compte);
			}catch(InputMismatchException e) {
				System.out.println("---- Taux doit etre un entier ----");
			}
			
		}catch(InputMismatchException e) {
			System.out.println("---- Nom doit etre une chaine ----");
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
				 throw new RuntimeException("---- Valeur entree pas correcte ----");
			}else if(idClient < Integer.MIN_VALUE) {
				throw new RuntimeException("---- Valeur entree pas correcte ----");
			}
			client1 = banque.getClient(idClient);
			if(client1 != null) {
				System.out.println(" ");
				System.out.print("Entrez le taux : ");
				taux = donnee.nextInt();
				if(taux > Integer.MAX_VALUE) {
					 throw new RuntimeException("---- Valeur entree pas correcte ----");
				}else if(taux < Integer.MIN_VALUE) {
					throw new RuntimeException("---- Valeur entree pas correcte ----");
				}
				compte = new Compte(client1, taux); 
				client1.printCompteClient();
				this.menuTransaction(banque, client1, compte);
			}else {
				System.out.println("---- Client n'existe pas ----");
			}
			
		}catch(InputMismatchException e) {
			System.out.println("---- Identifiant client et aux doivent etre un entier ----");
		}
	}
	
	public void menuCreerCompte(Banque banque) {
		System.out.println("###### Sous Menu Creer Compte - Entrez votre choix ######");
		System.out.println("###### Entrez 1 pour nouveau compte");
		System.out.println("###### Entrez 2 pour compte existant");
		System.out.println("###### Entrez 0 pour compte existant");
		Scanner sc = new Scanner(System.in); 
		int choix ;
		choix = sc.nextInt();
		if(choix > Integer.MAX_VALUE) {
			 throw new RuntimeException("---- Valeur entree pas correcte ----");
		}else if(choix < Integer.MIN_VALUE) {
			throw new RuntimeException("---- Valeur entree pas correcte ----");
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
				break; 
			}
			default: {
				this.messageErreur();
			}
		}
	}
	
	public void menuTransaction(Banque banque) {
		Scanner sc =new Scanner(System.in);
		int idClient ;
		String message ; 
		try {
			System.out.println("###### Menu Transaction - Entrez votre choix ######");
			System.out.print("Entrez l'identifiant du client :");
			idClient = sc.nextInt();
			if(idClient > Integer.MAX_VALUE) {
				 throw new RuntimeException("---- Valeur entree pas correcte ----");
			}else if(idClient < Integer.MIN_VALUE) {
				throw new RuntimeException("---- Valeur entree pas correcte ----");
			}
			Client client = banque.getClient(idClient);
			if( client != null) {
				System.out.print("Entrez le numero de compte : ");
				int numCompte ; 
				numCompte = sc.nextInt(); 
				if(numCompte > Integer.MAX_VALUE) {
					 throw new RuntimeException("---- Valeur entree pas correcte ----");
				}else if(numCompte < Integer.MIN_VALUE) {
					throw new RuntimeException("---- Valeur entree pas correcte ----");
				}
				Compte compte = client.getCompte(numCompte); 
				if(compte != null) {
					this.menuTransaction(banque,client, compte);
				}else {
					message = "---- Compte numero "+numCompte+" n'existe pas ----"; 
					this.mainMenu(message);
				}
			}else {
				message = "---- Client d'indentifiant "+idClient+" n'existe pas ----"; 
				this.mainMenu(message);
			}
			
		}catch(InputMismatchException e) {
			System.out.println("---- Identifiant client et numero compte aux doivent etre un entier ----");
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
					compte.printListeTransaction();
				}catch(InputMismatchException e) {
					System.out.println("---- Montant depot etre un nombre ----");
				}
				break; 
			}
			case 2 : {
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
					Transaction transaction =  new Transaction(client, compte,typeTransaction,montant );
					compte.printListeTransaction();
				}catch(InputMismatchException e) {
						System.out.println("---- Montant depot etre un nombre ----");
				}
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
