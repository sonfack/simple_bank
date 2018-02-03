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
		System.out.println("\n---- OK Client : "+this.nomClient+" identifiant : "+this.idClient+" ----\n" );
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
		System.out.println("---- Le client : "+this.nomClient+" pour Id : "+this.getIdClient()+" dispose des comptes suivants: ----" );
		for(int i = 0 ; i < this.listeCompte.size() ; i++) {
			System.out.println("* compte "+i+1+" pour numero de compte: "+this.listeCompte.get(i).getNumCompte());
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
