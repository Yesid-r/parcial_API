package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Taxi;
import com.example.demo.services.TaxiService;

@RestController
@CrossOrigin
@RequestMapping("/taxi")
public class TaxiController {

	@Autowired
	private TaxiService taxiService;
	
	@PostMapping("/saveTaxi")
	public Taxi saveTaxi(@RequestBody Taxi taxi) {
		return taxiService.saveTaxi(taxi);
	}
	
	@GetMapping("/listTaxis")
	public List<Taxi> listTaxis(){
		return taxiService.lisTaxis();
	}
	@GetMapping("/{idTaxi}")
	public Taxi findById(@PathVariable Long idTaxi) {
		return taxiService.findById(idTaxi);
	}
	
	/*@GetMapping("/TaxiMaxTarifa")
	public Taxi maxTarifa() {
		return taxiService.TaxiMaxTarifa();
	}
	*/
	
	
}
