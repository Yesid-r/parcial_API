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

import com.example.demo.entities.Carrera;
import com.example.demo.services.CarreraService;

@RestController
@CrossOrigin
@RequestMapping("/carrera")

public class CarreraController {

	@Autowired
	private CarreraService carreraService;
	
	@PostMapping("/saveCarrera")
	public Carrera saveCarrera(@RequestBody Carrera carrera) {
		return carreraService.saveCarrera(carrera);
	}
	
	@GetMapping("/listCarreras")
	public List<Carrera> lisCarreras(){
		return carreraService.listCarreras();
	}
	
	@GetMapping("/{idCarrera}")
	public Carrera findByIdCarrera(@PathVariable Long idCarrera) {
		return carreraService.findById(idCarrera);
	}
}
