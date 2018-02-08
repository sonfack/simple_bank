/**
 * 
 */
package com.ckomsa.controller;

import java.util.ArrayList;

import com.ckomsa.main.Banque;

/**
 * Classe permettant de gérer les clients
 * @author sonfack
 *
 */
public class Client {
	public static int indiceClient=0 ; 
	public String nomClient ; 
	private int idClient;
	
	public ArrayList<Compte> listeCompte = new ArrayList<Compte>(); 
	
	/**
	 * Constructeur de la classe Client n'ayant pas de compte dans la système
	 * @param banque est l objet de la classe Banque
	 * @param nom est le nom du client a créer 
	 * @param id represente l'identifiant du client
	 * le constructeur ajoute directement le client dans la liste de client
	 */
	public Client(Banque banque, String nom , int id) {
		// TODO Auto-generated constructor stub
		this.nomClient = nom.toUpperCase(); 
		this.idClient = id ; 
		banque.setListeClient(this);
	}
	
	
	/**
	 * Constructeur de la classe Client n'ayant pas de compte dans la système
	 * @param banque est l objet de la classe Banque
	 * @param nom est le nom du client a créer 
	 * Le constructeur ajoute directement le client dans la liste de client 
	 * Le constructeur crée automatique l'identifiant du client à créer 
	 */
	public Client(Banque banque, String nom) {
		Client.indiceClient = Client.indiceClient +1; 
		this.nomClient = nom.toUpperCase(); 
		this.idClient = Client.indiceClient ; 
		banque.setListeClient(this);
		System.out.print("\n---- Creer un nouveau compte pour "+this.nomClient+" avec :\n");
	}
	
	
	/**
	 * Cette methode permet de retourner l'identifiant d'un client
	 * @param client un objet de la classe Client
	 * @return idClient  l'identifiant de l'objet passé
	 */
	
	public int getIdClient(Client client) {
		return client.idClient; 
	}
	
	
	/**
	 * Cette methode permet de retourner l'identifiant d'un client
	 * cette fonction est sans paramettre
	 * @return idClient  l'identifiant de l'objet passé
	 */
	public int getIdClient() {
		return this.idClient; 
	}
	
	
	/**
	 * Cette fonction permet d'imprimer les comptes de tous les clients 
	 */
	public void printCompteClient() {
		
		int compte ; 
		if(this.listeCompte.size() >0) {
			System.out.println("---- Le client : "+this.nomClient+" pour Id : "+this.getIdClient()+" dispose de :"+this.listeCompte.size() +" ----" );
			for(int i = 0 ; i < this.listeCompte.size() ; i++) {
				compte = i+1; 
				System.out.println("* compte "+compte+" pour numero de compte: "+this.listeCompte.get(i).getNumCompte());
			}
		}else {
			System.out.println("---- Aucun compte pour "+this.nomClient+ " pour Id : "+this.getIdClient()+" ----");
		}
		
	}
	
	/**
	 * Cette fonction returne un compte etant donné un numero de compte
	 * @param numCompte le numero dont on recherche le compte
	 * @return null si aucun compte n a le numero ou le compte 
	 */
	public Compte getCompte(int numCompte) {
		Compte compte = null ;
		for(int i = 0 ; i < this.listeCompte.size(); i++) {
			if(this.listeCompte.get(i).getNumCompte() == numCompte) {
				compte = this.listeCompte.get(i); 
			}
		}
		return compte; 
	}
}
