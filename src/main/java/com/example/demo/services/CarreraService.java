package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.demo.entities.Carrera;
import com.example.demo.entities.Taxi;
import com.example.demo.repositories.IARepositoryCarrera;



@Service
public class CarreraService {
	
	@Autowired
	private IARepositoryCarrera iaRepositoryCarrera;

	public Carrera saveCarrera (Carrera carrera) {
		 Taxi taxi = carrera.getTaxi();
	        double distanciaMaxima = 0;

	        if (taxi.getTipoDeVehiculo() == 1) {
	            distanciaMaxima = 10;
	        } else if (taxi.getTipoDeVehiculo() == 2) {
	            distanciaMaxima = 20;
	        } else if (taxi.getTipoDeVehiculo() == 3) {
	            distanciaMaxima = 30;
	        }

	        if (carrera.getDistanciaRecorrida() > distanciaMaxima) {	
	        	
	        	System.out.println("La distancia recorrida es mayor a la distancia máxima permitida para el tipo de taxi");
	        }else {
	        	double valorTotal = carrera.getDistanciaRecorrida() * taxi.getTarifaPorKm();
		        carrera.setValorTotal(valorTotal);
		        iaRepositoryCarrera.save(carrera);
		        return carrera;
	        }

	        
	        

		
		return carrera;
	}
	
	public List<Carrera> listCarreras(){
		return iaRepositoryCarrera.findAll();
	}
	
	public Carrera findById(Long idCarrera) {
		Carrera carrera = iaRepositoryCarrera.findByIdCarrera(idCarrera);
		return carrera;
	}
}
