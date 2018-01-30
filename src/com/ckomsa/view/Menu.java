package com.ckomsa.view;

import java.io.IOException;
import java.util.Scanner;

import com.ckomsa.controller.Client;
import com.ckomsa.controller.Compte;
import com.ckomsa.main.Banque;

public class Menu {
	
	private static Menu menuInstance = null ; 
	
	protected  Menu(Banque banque) {
		// TODO Auto-generated constructor stub
		this.ClearScreen();
		System.out.println("########## Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour rechercher "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 2 pour une transaction"); 
		System.out.println("#### 0 pour sortir de l'application ####");
	}
	
	protected Menu(Banque banque, String message) {
		this.ClearScreen();
		System.out.println("---------------------------------------------------------");
		System.out.println(message);
		System.out.println("---------------------------------------------------------");
		System.out.println("########## Menu Principal - Entrez votre choix ##########");
		System.out.println("#### Entrez 1 pour rechercher "); 
		System.out.println("#### Entrez 2 pour créer un nouveau compte");
		System.out.println("#### Entrez 2 pour une transaction"); 
		System.out.println("#### 0 pour sortir de l'application ####");
	}
	
	public static Menu getInstanceMenu(Banque banque) {
		if(menuInstance == null) {
			menuInstance = new Menu(banque); 
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
	
	public void MenuRecherche(Banque banque) {
		this.ClearScreen();
		System.out.println("Menu Recherche - Entrez votre choix");
		System.out.println("Entrez 1 pour recherche par nom  "); 
		System.out.println("Entrez 2 pour recherche par identifiant");	
		System.out.println("#### 0 pour sortir de l'application ####");
	}
	
	public void MenuCreerCompte(Banque banque) {
		this.ClearScreen();
		Scanner donnee =new Scanner(System.in);
		String nom ; 
		int idClient ;
		int idCompte; 
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
		client1 =  new Client(banque, nom, idClient);
		compte = new Compte(client1, idCompte); 
		this.MenuTransaction(banque);
	}
	
	public void MenuTransaction(Banque banque) {
		this.ClearScreen();
		Scanner sc =new Scanner(System.in);
		int choix ; 
		//int choix = sc.nextInt(); 
		System.out.println("###### Menu Transaction - Entrez votre choix ######");
		System.out.println("Entrez 1 pour depot  "); 
		System.out.println("Entrez 2 pour retrait");	
		System.out.println("#### 0 pour sortir de l'application ####");
		choix = sc.nextInt();
		switch(choix) {
			case 1 : {
				System.out.println("depot");
				break; 
			}
			case 2 : {
				System.out.println("retrait");
				break ; 
			}
			default: {
				this.MessageErreur();
			}
		}
	}
	
	
	public void MessageErreur() {
		this.ClearScreen();
		System.out.println("Votre choix n est pas bon");
	}
}
