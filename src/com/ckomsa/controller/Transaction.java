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
	
	// Création d'une transaction avec un type de transaction et sans montant
	public Transaction(Client client, Compte compte, TypeTransaction type, double montant) {
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
					break ;
				}
				 
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
				System.out.println(montant+" Transaction OK");
				break; 
			}
			
		}
		
	}
	
	public String getNomTypeTransaction() {
		String nomTypeTransaction ; 
		nomTypeTransaction = this.typeTransaction.getTypeTransaction(); 
		return nomTypeTransaction; 
	}
	
	public Date getDateTransaction() {
		return this.dateTransation; 
	}
	
	public double getMontantTransaction() {
		return this.montantTransaction ; 
	}

}
