package com.registro.vehiculos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "marca", length = 40, nullable = false)
	private String marca;

	@Column(name = "modelo", length = 40, nullable = false)
	private String modelo;

	@Column(name = "color", length = 40, nullable = false)
	private String color;

	@Column(name = "placa", length = 40, nullable = false, unique = true)
	private String placa;

	@Column(name = "chasis", length = 40, nullable = false, unique = true)
	private String chasis;

	@Column(name = "anio", length = 40, nullable = false)
	private String anio;

	@Column(name = "propietario", length = 40, nullable = false)
	private String propietario;

	public Vehiculo() {

	}

	public Vehiculo(Long id, String marca, String modelo, String color, String placa, String chasis, String anio,
			String propietario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.placa = placa;
		this.chasis = chasis;
		this.anio = anio;
		this.propietario = propietario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

}
