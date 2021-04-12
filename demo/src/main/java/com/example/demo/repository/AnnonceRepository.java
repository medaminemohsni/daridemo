package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Annonce;
@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>, PagingAndSortingRepository<Annonce, Long> {

}
