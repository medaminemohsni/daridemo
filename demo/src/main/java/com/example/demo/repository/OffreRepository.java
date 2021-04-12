package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Offre;
@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>, PagingAndSortingRepository<Offre, Long> {

}
