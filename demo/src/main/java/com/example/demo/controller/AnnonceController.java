package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.AnnonceRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.AnnonceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/annonce")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;

	@PostMapping()
	public Object registerAnnonce(@RequestBody AnnonceRequest annonceRequest) {
		try {
			return annonceService.save(annonceRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));

		}
	}

	@PutMapping("/achat/{id}")
	public void achat(@PathVariable Long id) {

		annonceService.achat(id);

	}
	
	@PutMapping("/livraison/{id}/{etat}")
	public void livraison(@PathVariable Long id,@PathVariable String etat) {

		annonceService.livraison(etat,id);

	}
}
