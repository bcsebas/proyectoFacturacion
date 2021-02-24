package edu.ucacue.microservicios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcli;
	@Column(columnDefinition = "integer default 10")
	private int nif;

	@Column(columnDefinition = "text")
	private String nombre;
	@Column(columnDefinition = "text")
	private String direccion;

	public Cliente(int nif, String nombre, String direccion) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Cliente() {
	}

	public int getId() {
		return idcli;
	}

	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

}
