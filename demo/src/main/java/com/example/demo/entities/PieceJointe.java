package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PieceJointe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	String attachementName;

	@Column(columnDefinition = "LONGTEXT")
	String attachementData;

	@ManyToOne
	@JoinColumn(name = "offre_id", nullable = true)
	private Offre offre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachementName() {
		return attachementName;
	}

	public void setAttachementName(String attachementName) {
		this.attachementName = attachementName;
	}

	public String getAttachementData() {
		return attachementData;
	}

	public void setAttachementData(String attachementData) {
		this.attachementData = attachementData;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	
	
}
