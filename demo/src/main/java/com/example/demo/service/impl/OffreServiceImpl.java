package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Offre;
import com.example.demo.entities.PieceJointe;
import com.example.demo.entities.User;
import com.example.demo.enums.TypeOffreEnum;
import com.example.demo.repository.OffreRepository;
import com.example.demo.repository.PieceJointeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.OffreRequest;
import com.example.demo.request.PieceJointeRequest;
import com.example.demo.service.OffreService;

@Service
public class OffreServiceImpl implements OffreService {

	@Autowired
	OffreRepository offreRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PieceJointeRepository pieceJointeRepository;

	@Override
	public Offre save(OffreRequest offreRequest) {
		Offre offre = new Offre();
		offre.setCreationDate(offreRequest.getCreationDate());
		offre.setDescriptif(offreRequest.getDescriptif());
		offre.setPrix(offreRequest.getPrix());
		offre.setTypeOffreEnum(TypeOffreEnum.valueOf(offreRequest.getTypeOffreEnum()));
		User user = userRepository.findById(offreRequest.getUserId())
				.orElseThrow(() -> new RuntimeException("null id"));
		offre.setUser(user);
		Offre newOffre = offreRepository.save(offre);

		for (PieceJointeRequest PJ : offreRequest.getPiecesJointes()) {
			PieceJointe pieceJointe = new PieceJointe();
			pieceJointe.setAttachementData(PJ.getAttachementData());
			pieceJointe.setAttachementName(PJ.getAttachementName());
			pieceJointe.setOffre(newOffre);
			pieceJointeRepository.save(pieceJointe);
		}

		return newOffre;
	}

}
