package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.enums.DeliveryState;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Annonce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column()
	@Enumerated(EnumType.STRING)
	private DeliveryState livraison;

	@Column()
	@Temporal(TemporalType.TIMESTAMP)
	Date creationDate;

	@Column
	private String descriptif;

	@Column
	private Double prix;

	@OneToMany(mappedBy = "anonce", cascade = CascadeType.REMOVE)
	private List<Meuble> meubles = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Meuble> getMeubles() {
		return meubles;
	}

	public void setMeubles(List<Meuble> meubles) {
		this.meubles = meubles;
	}

	public DeliveryState getLivraison() {
		return livraison;
	}

	public void setLivraison(DeliveryState livraison) {
		this.livraison = livraison;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
