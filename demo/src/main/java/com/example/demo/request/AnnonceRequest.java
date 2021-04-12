package com.example.demo.request;

import java.util.Date;
import java.util.List;

public class AnnonceRequest {

	String livraison;

	Date creationDate;

	String descriptif;

	Double prix;

	Long userId;
	
	List<MeubleRequest> meubles;

	public String getLivraison() {
		return livraison;
	}

	public void setLivraison(String livraison) {
		this.livraison = livraison;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<MeubleRequest> getMeubles() {
		return meubles;
	}

	public void setMeubles(List<MeubleRequest> meubles) {
		this.meubles = meubles;
	}
	
	
}
