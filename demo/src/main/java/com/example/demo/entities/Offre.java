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

import com.example.demo.enums.TypeOffreEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column()
	@Enumerated(EnumType.STRING)
	private TypeOffreEnum typeOffreEnum;

	@Column()
	@Temporal(TemporalType.TIMESTAMP)
	Date creationDate;

	@Column
	private String descriptif;

	@Column
	private Double prix;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id", nullable = true)
	private User user;


	@OneToMany(mappedBy = "offre", cascade = CascadeType.REMOVE)
	private List<PieceJointe> piecesJointes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeOffreEnum getTypeOffreEnum() {
		return typeOffreEnum;
	}

	public void setTypeOffreEnum(TypeOffreEnum typeOffreEnum) {
		this.typeOffreEnum = typeOffreEnum;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PieceJointe> getPiecesJointes() {
		return piecesJointes;
	}

	public void setPiecesJointes(List<PieceJointe> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}
	
	

}
