/**
 * 
 */
package com.ckomsa.controller;

import java.util.ArrayList;

import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
public class Client {
	public static int indiceClient=0 ; 
	public String nomClient ; 
	private int idClient;
	
	public ArrayList<Compte> listeCompte = new ArrayList<Compte>(); 
	
	/**
	 * Constructeur de la classe Client sans Compte
	 */
	public Client(Banque banque, String nom , int id) {
		// TODO Auto-generated constructor stub
		this.nomClient = nom.toUpperCase(); 
		this.idClient = id ; 
		banque.setListeClient(this);
	}
	
	public Client(Banque banque, String nom) {
		// TODO Auto-generated constructor stub
		Client.indiceClient = Client.indiceClient +1; 
		this.nomClient = nom.toUpperCase(); 
		this.idClient = Client.indiceClient ; 
		banque.setListeClient(this);
		System.out.print("\n---- Creer un nouveau compte pour "+this.nomClient+" avec :\n");
	}
	
	
	/*
	 * Cette fonction returne l'identifiant du client
	 */
	
	public int getIdClient(Client client) {
		return client.idClient; 
	}
	
	public int getIdClient() {
		return this.idClient; 
	}
	
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
