package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.OffreRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.OffreService;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/offre")
public class OffreController {
	
	@Autowired
	OffreService offreService;

	@PostMapping()
	public Object registerOffre(@RequestBody OffreRequest offreRequest) {
		try {
			return offreService.save(offreRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));

		}
	}

}
