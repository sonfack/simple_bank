/**
 * 
 */
package com.ckomsa.controller;

import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
public class TypeTransaction {
	private String nomTypeTransaction ; 
	
	/*
	 * Constructeur de type de transaction 
	 * NB: ne doit par créer une transation existante
	 */
	public TypeTransaction(Banque banque, String type) {
		this.setTypeTransaction(type); 
		if(! banque.getTypeTransaction().contains(this)) {
			banque.setListeTypeTransaction(this);
		}
	}
	
	public void setTypeTransaction(String type) {
		this.nomTypeTransaction = type.toLowerCase(); 
	}
	
	public String getTypeTransaction() {
		return this.nomTypeTransaction; 
	}
	
}
