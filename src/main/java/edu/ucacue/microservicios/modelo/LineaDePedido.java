package edu.ucacue.microservicios.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="linea_de_pedidos")
public class LineaDePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ldp;
	@Column(columnDefinition = "integer default 200")
	private int cantidad;
	@Column(columnDefinition = "integer default 200")
	private double precioUnitario;
	@Column(columnDefinition = "integer default 200")
	private double descuento;
	
	@ManyToOne
	@JoinColumn(name="pedido_fk")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="producto_fk")
	private Producto producto;
	
	
	

	public LineaDePedido(int id_ldp, int cantidad, double precioUnitario, double descuento, Pedido pedido,
			Producto producto) {
		super();
		this.id_ldp = id_ldp;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	

	public LineaDePedido() {
		super();
	}



	public int getId_ldp() {
		return id_ldp;
	}

	public void setId_ldp(int id_ldp) {
		this.id_ldp = id_ldp;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	


	
	
}
