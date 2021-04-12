package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.PieceJointe;
@Repository
public interface PieceJointeRepository
		extends JpaRepository<PieceJointe, Long>, PagingAndSortingRepository<PieceJointe, Long> {

}
