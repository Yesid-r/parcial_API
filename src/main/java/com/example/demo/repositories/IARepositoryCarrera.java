package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Carrera;

@Repository
public interface IARepositoryCarrera extends JpaRepository<Carrera, Long>{
	
	public Carrera findByIdCarrera (Long idCarrera);

}
