/**
 * 
 */
package com.ckomsa.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sonfack
 *
 */
public class Compte{
	public static int indiceCompte  = 0;  
	// liste des transactions du compte
	ArrayList<Transaction> listeTransaction = new ArrayList<Transaction>(); 
	//private Client client;
	private int numCompte; 
	private double solde ;
	public int tauxInteret; 
	
	/*
	 * Constructeur de la classe Compte qui permet de créer un compte sans transaction
	 */
	
	public Compte(Client client, int taux ) {
		Compte.indiceCompte = Compte.indiceCompte + 1; 
		this.numCompte = Compte.indiceCompte ;
		this.solde = 0;
		this.tauxInteret = taux;
		client.listeCompte.add(this);
		System.out.println("\tCompte = "+this.numCompte+" ; nom client = "+client.nomClient+" identifiant = "+client.getIdClient(client)+" ; montant = "+this.getSolde() +" et taux = "+this.tauxInteret+"%" );
	}
	
	
	public Compte(Client client) {
		Compte.indiceCompte = Compte.indiceCompte + 1; 
		this.numCompte = Compte.indiceCompte ;
		this.solde = 0;
		this.tauxInteret = 0;
		client.listeCompte.add(this);
		System.out.println("\tCompte = "+this.numCompte+" ; nom client = "+client.nomClient+" identifiant = "+client.getIdClient(client)+" ; montant = "+this.getSolde() +" et taux = "+this.tauxInteret+"%" );
	}
	
	
	public void printTransaction(Transaction transaction) {
		if(transaction != null) {
			if(transaction.getNomTypeTransaction().equals("depot")) {
				 System.out.println("---- Dépot un montant de "+transaction.getMontantTransaction()+"Euros pour le compte "+this.getNumCompte()+" au "+transaction.getDateTransaction()+" ----");

			}else if(transaction.getNomTypeTransaction().equals("retrait")) {
				 System.out.println("---- Retrait un montant de "+transaction.getMontantTransaction()+"Euros pour le compte "+this.getNumCompte()+" au "+transaction.getDateTransaction()+" ----");
				
			}
		}else {
			System.out.println("null");
		}
	}
	
	
	public void printListeTransaction(String nomTypeTransaction) {
		 for (int i = 0; i < this.getListeTransaction().size(); i++) {
			 if(nomTypeTransaction.equals(this.getListeTransaction().get(i).getNomTypeTransaction())) {
				 if(nomTypeTransaction.equals("depot")) {
					 System.out.println("---- Dépot un montant de "+this.getListeTransaction().get(i).getMontantTransaction()+" pour le compte "+this.getNumCompte()+" au "+this.getListeTransaction().get(i).getDateTransaction()+" ----");
				 }else if(nomTypeTransaction.equals("retrait")) {
					 System.out.println("---- Retrait un montant de "+this.getListeTransaction().get(i).getMontantTransaction()+" pour le compte "+this.getNumCompte()+" au "+this.getListeTransaction().get(i).getDateTransaction()+" ----");
				 }
				
			 }
	     } 
	}
	
	
	/**
	 * Cette fonction returne la liste des transaction d'un compte
	 * 
	 */
	public  ArrayList<Transaction> getListeTransaction() {
		return this.listeTransaction ; 
	}
	
	public void setListeTransaction(Transaction transaction) {
		this.listeTransaction.add(transaction); 
	}
	
	
	/**
	 * Cette methode calcul l'interet d'un solde 
	 * @param taux
	 */
	public void setInteret() {
		this.setSolde((this.getSolde()*this.getTaux())/100 + this.getSolde()); 
	}
	
	/**
	 * Cette fonction retourne le numéro de compte
	 */
	
	public double getSolde() {
		return this.solde; 
	}
	
	/**
	 * Cette fonction retourne le taux d'interet d'un compte
	 */
	public int getTaux() {
		return this.tauxInteret; 
	}
	
	/**
	 *Cette fonction permet d'initialiser un numero de compte 
	 */
	public void setNumCompte(int numcompte) {
		this.numCompte = numcompte;
	}
	
	/**
	 * Cette fonction permet d'initialiser un solde 
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	/**
	 * Cette fonction retour 
	 */
	public int getNumCompte() {
		return this.numCompte; 
	}
	
	/**
	 * Cette fonction permet d'ajouter une transaction a un compte
	 * 
	 */
	public boolean setTransation(Transaction transaction) {
		this.listeTransaction.add(transaction); 
		return true ; 
	}

}
