package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Meuble;
@Repository
public interface MeubleRepository extends JpaRepository<Meuble, Long>, PagingAndSortingRepository<Meuble, Long> {

}
