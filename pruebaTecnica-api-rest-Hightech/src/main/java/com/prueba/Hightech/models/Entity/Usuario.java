package com.prueba.Hightech.models.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	
	@NotEmpty
	@Column(nullable=false)
	private String nombre;

	@NotEmpty	
	@Column(nullable=false)
	private String apellido;
	
	@NotEmpty
	@Column(nullable=false)
	@Email
	private String email;
	
	@NotEmpty
	@Column(nullable=false)
	private String username;
	
	@NotEmpty
	@Column(nullable=false)
	private String password;

	@Column(nullable=false)
	private boolean activo;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_rol"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"id_usuario", "id_rol"})})
	private List<Rol> roles;
	
	
	
	public Usuario() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", activo=" + activo + ", roles=" + roles + "]";
	}
	
	
}
