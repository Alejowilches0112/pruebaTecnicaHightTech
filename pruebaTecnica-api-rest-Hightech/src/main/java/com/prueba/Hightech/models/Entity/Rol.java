package com.prueba.Hightech.models.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="roles")
@Entity
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_rol;
	@Column(unique=true)
	private String nombre_rol;
	
	public long getId_rol() {
		return id_rol;
	}
	public void setId_rol(long id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre_rol() {
		return nombre_rol;
	}
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
	
	
}
