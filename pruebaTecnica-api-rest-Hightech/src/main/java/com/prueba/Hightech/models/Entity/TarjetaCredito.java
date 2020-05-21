package com.prueba.Hightech.models.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="tarjetas_credito")
public class TarjetaCredito implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long nro_tarjeta;
	
	@NotNull
	private long mes_vence;
	@NotNull
	private long anio_vence;
	
	
	public long getNro_tarjeta() {
		return nro_tarjeta;
	}
	
	public void setNro_tarjeta(long nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}
	
	public long getMes_vence() {
		return mes_vence;
	}
	
	public void setMes_vence(long mes_vence) {
		this.mes_vence = mes_vence;
	}
	
	public long getAnio_vence() {
		return anio_vence;
	}
	
	public void setAnio_vence(long anio_vence) {
		this.anio_vence = anio_vence;
	}
	
}
