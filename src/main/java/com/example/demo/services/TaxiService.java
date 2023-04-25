package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Taxi;
import com.example.demo.repositories.IARepositoryTaxi;

@Service
public class TaxiService {
	
	@Autowired
	private IARepositoryTaxi iaRepositoryTaxi;
	
	public Taxi saveTaxi(Taxi taxi) {
		iaRepositoryTaxi.save(taxi);
		return taxi;
		
	}
	public List<Taxi> lisTaxis(){
		return iaRepositoryTaxi.findAll();
	}

	public Taxi findById(Long idTaxi) {
        Taxi taxi = iaRepositoryTaxi.findByIdTaxi(idTaxi);

        return taxi;
    }
	/*
	public Taxi TaxiMaxTarifa() {
		Taxi taxi = iaRepositoryTaxi.findMaxTarifa();
		
		return null;
	}
	*/
}
