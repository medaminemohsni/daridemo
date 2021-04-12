package com.example.demo.request;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OffreRequest {

	String typeOffreEnum;

	Date creationDate;

	String descriptif;

	Double prix;

	Long userId;

	List<PieceJointeRequest> piecesJointes;

	public String getTypeOffreEnum() {
		return typeOffreEnum;
	}

	public void setTypeOffreEnum(String typeOffreEnum) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<PieceJointeRequest> getPiecesJointes() {
		return piecesJointes;
	}

	public void setPiecesJointes(List<PieceJointeRequest> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}
	
	
}
