package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Taxi;

@Repository
public interface IARepositoryTaxi extends JpaRepository<Taxi, Long> {

	public Taxi findByIdTaxi(Long idTaxi);
	
	@Query(value = "SELECT t FROM Taxi t WHERE TARIFA_POR_KM = (SELECT MAX(TARIFA_POR_KM) FROM taxi)")
	public Taxi findMaxTarifa();
}
