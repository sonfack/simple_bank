/**
 * Cette classe permet de creer des types de transaction 
 */
package com.ckomsa.controller;

import com.ckomsa.main.Banque;

/**
 * @author sonfack
 *
 */
public class TypeTransaction {
	private String nomTypeTransaction ; 
	
	/**
	 * Constructeur de type de transaction 
	 * NB: ne doit par créer une transation existante
	 * @param banque  qui est la Banque 
	 * @param type est le type de transaction 
	 * Ce constructeur ajoute automatiquement le type 
	 * de transaction dans la liste des transaction de la banque 
	 */
	public TypeTransaction(Banque banque, String type) {
		this.setTypeTransaction(type); 
		if(! banque.getTypeTransaction().contains(this)) {
			banque.setListeTypeTransaction(this);
		}
	}
	
	/**
	 * Cette methode permet d'affecter le nom du type de transaction 
	 * @param type
	 */
	public void setTypeTransaction(String type) {
		this.nomTypeTransaction = type.toLowerCase(); 
	}
	
	/**
	 * Cette methode permet de retourner le nom d'un type de transaction
	 * @return le nom du type de transaction
	 */
	public String getTypeTransaction() {
		return this.nomTypeTransaction; 
	}
	
}
