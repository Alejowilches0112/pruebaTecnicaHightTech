package com.prueba.Hightech.models.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(unique = true ,nullable=false)
	private long identificacion;
	
	@NotEmpty(message="Es un campo obligatoria")
	@Column(nullable=false)
	private String nombre1;
	
	private String nombre2;
	
	@NotEmpty(message="Es un campo obligatoria")
	@Column(nullable=false)
	private String apellido1;
	
	private String apellido2;
	
	@NotEmpty(message="Es un campo obligatoria")
	@Column(nullable=false)
	@Email
	private String email;
	
	@NotEmpty(message="Es un campo obligatoria")
	@Column(nullable=false)
	private String direccion;
	
	@NotNull(message="Es un campo obligatoria")
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_nacto;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TarjetaCredito> tarjetas;

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacto() {
		return fecha_nacto;
	}

	public void setFecha_nacto(Date fecha_nacto) {
		this.fecha_nacto = fecha_nacto;
	}

	public List<TarjetaCredito> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaCredito> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
}
