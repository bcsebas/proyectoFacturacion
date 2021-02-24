package edu.ucacue.microservicios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpro;
	@Column(columnDefinition = "text", unique = true, nullable = false )
	private int codigo;
	@Column(columnDefinition = "text")
	private String descripcion;
	@Column(columnDefinition = "integer default 200")
	private double precioUnitario;
	
	
	
	public Producto() {
		super();
	}
	public Producto(int codigo, String descripcion, double precioUnitario) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}
	public int getIdpro() {
		return idpro;
	}
	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	


}
