package com.prj.albumdefigurinhas.reposiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.albumdefigurinhas.model.Figurinha;


@Repository
public interface FigurinhaRepository extends JpaRepository<Figurinha, Long> {

    Optional<Figurinha> findById(Long id);



}