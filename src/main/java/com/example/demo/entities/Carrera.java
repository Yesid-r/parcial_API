package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "CARRERAS")
public class Carrera implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CARRERA")
	private Long idCarrera;
	
	@ManyToOne(optional = true,
		    cascade = {CascadeType.PERSIST,
		    CascadeType.MERGE}, fetch = FetchType.LAZY)
		    @JoinColumn(name = "taxi_id")
	private Taxi taxi;
    
	@Column (name = "DISTANCIA_RECORRIDA")
	private double distanciaRecorrida;
	
    @Column (name = "VALOR_TOTAL")
    private double valorTotal;
    
    
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
	public Long getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
	}
	public Taxi getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	public double getDistanciaRecorrida() {
		return distanciaRecorrida;
	}
	public void setDistanciaRecorrida(double distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
