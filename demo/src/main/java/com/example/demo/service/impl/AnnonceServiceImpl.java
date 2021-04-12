package com.example.demo.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Meuble;
import com.example.demo.entities.User;
import com.example.demo.enums.DeliveryState;
import com.example.demo.repository.AnnonceRepository;
import com.example.demo.repository.MeubleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.AnnonceRequest;
import com.example.demo.request.MeubleRequest;
import com.example.demo.service.AnnonceService;
import com.example.demo.utils.SendMail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class AnnonceServiceImpl implements AnnonceService {

	@Autowired
	AnnonceRepository annonceRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MeubleRepository meubleRepository;

	@Override
	public Annonce save(AnnonceRequest annonceRequest) {
		Annonce annonce = new Annonce();
		annonce.setCreationDate(annonceRequest.getCreationDate());
		annonce.setDescriptif(annonceRequest.getDescriptif());
		annonce.setPrix(annonceRequest.getPrix());
		User user = userRepository.findById(annonceRequest.getUserId())
				.orElseThrow(() -> new RuntimeException("null id"));
		annonce.setUser(user);
		Annonce newAnnonce = annonceRepository.save(annonce);

		for (MeubleRequest meuble : annonceRequest.getMeubles()) {
			Meuble newMeuble = new Meuble();
			newMeuble.setNom(meuble.getNom());
			newMeuble.setDescriptif(meuble.getDescriptif());
			newMeuble.setAnonce(newAnnonce);
			meubleRepository.save(newMeuble);
		}
		return newAnnonce;
	}

	@Override
	public void achat(Long id) {

		Annonce annonce = annonceRepository.findById(id).orElseThrow(() -> new RuntimeException("null id"));
		annonce.setLivraison(DeliveryState.EN_ATTENTE);
		User user = annonce.getUser();
		try {
			exportReport(annonce);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SendMail.sendMail(user.getEmail(), annonce.getId());
	}

	private String exportReport(Annonce annonce) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\Admin\\git\\Esprit-PiDev";

		// load file and compile it
		File file = ResourceUtils.getFile("classpath:Items.xml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(annonce.getMeubles());
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Java Techie");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\items.pdf");


		return "report generated in path : " + path;
	}

	@Override
	public void livraison(String etat, Long id) {
		Annonce annonce = annonceRepository.findById(id).orElseThrow(() -> new RuntimeException("null id"));
		annonce.setLivraison(DeliveryState.valueOf(etat));
		annonceRepository.save(annonce);
	}



}
