/**
 * 
 */
package com.ckomsa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
public class Transaction {
	private TypeTransaction typeTransaction ; 
	private Date dateTransation ; 
	private double montantTransaction ; 
	
	/**
	 * Création d'une transaction avec un type de transaction et sans montant
	 * @param client
	 * @param compte
	 * @param type
	 * @param montant
	 */
	public Transaction(Client client, Compte compte, TypeTransaction type, double montant) {
		if(montant > 0) {
			switch(type.getTypeTransaction()) {
			case "retrait":{
				if(compte.getSolde() < montant) {
					System.out.println("Solde insufisant");
				}else {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					this.dateTransation  = new Date();
					// le montant doit etre positif 
					this.montantTransaction = montant; 
					this.typeTransaction = type; 
					// ajout de la transaction dans le compte
					compte.getListeTransaction().add(this); 
					compte.setSolde(compte.getSolde() - montant); 
					System.out.println("Transaction OK");
					compte.printTransaction(this);	
				}
				break ;
			}
			case "depot" : {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				this.dateTransation  = new Date();
				// le montant doit etre positif 
				this.montantTransaction = montant; 
				this.typeTransaction = type; 
				// ajout de la transaction dans le compte
				compte.getListeTransaction().add(this); 
				compte.setSolde(compte.getSolde() + montant); 
				System.out.println("Transaction OK");
				compte.printTransaction(this);
				break; 
			}
			
		}
		}else {
			System.out.println("Echec transation \n---- Montant nul ou negatif ----");
		}
	}

	/**
	 * Cette methode permet de retouner le nom d'une transaction
	 * @return nom du type de transaction
	 */
	public String getNomTypeTransaction() {
		String nomTypeTransaction ; 
		nomTypeTransaction = this.typeTransaction.getTypeTransaction(); 
		return nomTypeTransaction; 
	}
	
	/**
	 * Cette methode permet de retourner la date d'une transaction
	 * @return date d'une transaction
	 */
	public Date getDateTransaction() {
		return this.dateTransation; 
	}
	
	/**
	 * Cette fonction permet de retourner le montant d'une transaction
	 * @return montant de la transaction
	 */
	public double getMontantTransaction() {
		return this.montantTransaction ; 
	}

}
