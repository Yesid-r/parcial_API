package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAXI")
public class Taxi implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IDTAXI")
	private Long idTaxi;
	
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "TARIFA_POR_KM")
    private double tarifaPorKm;
    
    @Column(name = "TIPO_VEHICULO")
    private int tipoDeVehiculo;
    
    
    @OneToMany(mappedBy = "taxi")
    private List<Carrera> carreras;
	
    public Taxi() {
		// TODO Auto-generated constructor stub
	}

	

	public Long getIdTaxi() {
		return idTaxi;
	}



	public void setIdTaxi(Long idTaxi) {
		this.idTaxi = idTaxi;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getTarifaPorKm() {
		return tarifaPorKm;
	}

	public void setTarifaPorKm(double tarifaPorKm) {
		this.tarifaPorKm = tarifaPorKm;
	}

	public int getTipoDeVehiculo() {
		return tipoDeVehiculo;
	}

	public void setTipoDeVehiculo(int tipoDeVehiculo) {
		this.tipoDeVehiculo = tipoDeVehiculo;
	}

	
    

}
