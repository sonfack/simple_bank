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
	// liste des transactions du compte
	ArrayList<Transaction> listeTransaction = new ArrayList<Transaction>(); 
	private Client client;
	private int numCompte; 
	private double solde ;
	public int tauxInteret; 
	
	/*
	 * Constructeur de la classe Compte qui permet de créer un compte sans transaction
	 */
	public Compte(Client client,  int ncompte ) {
		this.numCompte = ncompte;
		this.solde = 0;
		this.tauxInteret = 0;
		//this.listeTransaction =  null; 
		client.listeCompte.add(this);
	}
	
	/*
	 * Cette fonction returne la liste des transaction d'un compte
	 * 
	 */
	public  ArrayList<Transaction> getListeTransaction() {
		return this.listeTransaction ; 
	}
	
	public void setListeTransaction(Transaction transaction) {
		this.listeTransaction.add(transaction); 
	}
	
	
	/*
	 * Cette fonction retourne le numéro de compte
	 */
	
	public double getSolde() {
		return this.solde; 
	}
	
	/*
	 * Cette fonction retourne le taux d'interet d'un compte
	 */
	public int getTaux() {
		return this.tauxInteret; 
	}
	
	/*
	 *Cette fonction permet d'initialiser un numero de compte 
	 */
	public void setNumCompte(int numcompte) {
		this.numCompte = numcompte;
	}
	
	/*
	 * Cette fonction permet d'initialiser un solde 
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	/*
	 * 
	 */
	public int getNumCompte() {
		return this.numCompte; 
	}
	
	/*
	 * Cette fonction permet d'ajouter une transaction a un compte
	 * 
	 */
	public boolean setTransation(Transaction transaction) {
		this.listeTransaction.add(transaction); 
		return true ; 
	}

}
