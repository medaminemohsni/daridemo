package com.example.demo.service;

import com.example.demo.entities.Annonce;
import com.example.demo.request.AnnonceRequest;

public interface AnnonceService {

	Annonce save(AnnonceRequest annonceRequest);

	void achat(Long id);

	void livraison(String etat, Long id);

}
