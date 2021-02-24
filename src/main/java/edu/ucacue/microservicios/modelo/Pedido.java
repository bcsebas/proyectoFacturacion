package edu.ucacue.microservicios.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ped;
	
	@Column(columnDefinition = "integer default 10")
	private int numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="cliente_fk")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineaDePedido> pedidoDeLineas;

	

	public Pedido() {
		super();
	}


	public int getId_ped() {
		return id_ped;
	}



	public void setId_ped(int id_ped) {
		this.id_ped = id_ped;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<LineaDePedido> getPedidoDeLineas() {
		return pedidoDeLineas;
	}



	public void setPedidoDeLineas(List<LineaDePedido> pedidoDeLineas) {
		this.pedidoDeLineas = pedidoDeLineas;
	}



	@Override
	public String toString() {
		return "\n Pedido [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente
				+ "]";
	}
	
	
	
	
}