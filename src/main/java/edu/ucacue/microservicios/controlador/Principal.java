package edu.ucacue.microservicios.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.ucacue.microservicios.infraestructura.repositorio.ClienteRepositorio;
import edu.ucacue.microservicios.infraestructura.repositorio.PedidoRepositorio;
import edu.ucacue.microservicios.infraestructura.repositorio.ProductoRepositorio;
import edu.ucacue.microservicios.modelo.Cliente;
import edu.ucacue.microservicios.modelo.LineaDePedido;
import edu.ucacue.microservicios.modelo.Pedido;
import edu.ucacue.microservicios.modelo.Producto;

@Controller
public class Principal {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Autowired
	PedidoRepositorio pedidoRepositorio;

	@Autowired
	ProductoRepositorio productoRepositorio;

	public Principal() {
		System.out.println("hola");
		System.out.println("ddd");
	}

	public void interfaz() {
		Scanner input = new Scanner(System.in);
		boolean mainLoop = true;

		int choice;
		while (true) {
			System.out.println("\nEscoja una opcion del menu");
			System.out.print("1.) Ingresar cliente  \n");
			System.out.print("2.) Generar \n");
			System.out.print("3.) Listar \n");
			System.out.print("4.) Ingresar productos\n");
			System.out.print("5.) Listar productos\n");
			System.out.print("6.) Salir.\n");

			System.out.print("\n Ingrese la opcion del Menú: ");

			choice = input.nextInt();

			switch (choice) {

			case 1:

				String nombre, direccion;
				int nif;
				System.out.print("Ingrese el nif: ");
				nif = input.nextInt();
				System.out.print("Ingrese el Nombre: ");
				nombre = input.next();
				System.out.print("Ingrese la Dirección: ");
				direccion = input.next();

				Cliente p = new Cliente(nif, nombre, direccion);

				clienteRepositorio.save(p);
				break;
			case 2:
				System.out.print("Ingrese el id: ");
				int id = input.nextInt();
				Cliente pF = clienteRepositorio.findById(id).get();
				if (pF == null) {
					System.out.println("Dato no encontrado");
					break;
				}
				Pedido pedido = new Pedido();
				pedido.setCliente(pF);

				System.out.print("Ingrese el número de pedido: ");
				int np = input.nextInt();
				pedido.setNumero(np);

				pedido.setFecha(new Date());

				System.out.println("Cuantos productos pedirá: ");
				int numProductos = input.nextInt();
				List<LineaDePedido> linea = new ArrayList();

				for (int i = 0; i < numProductos; i++) {
					LineaDePedido lp = new LineaDePedido();
					System.out.println("Ingrese el id del producto:");
					int idp = input.nextInt();
					Producto productoEncontrado = productoRepositorio.findById(idp).get();

					lp.setProducto(productoEncontrado);
					lp.setPedido(pedido);

					System.out.println("Ingrese cantidad del producto: ");
					lp.setCantidad(input.nextInt());
					System.out.println("Ingrese precio");
					lp.setPrecioUnitario(input.nextDouble());
					System.out.println("Ingrese porcentaje del descuento");
					lp.setDescuento(input.nextDouble());

					linea.add(lp);
				}

				pedido.setPedidoDeLineas(linea);

				pedidoRepositorio.save(pedido);

				break;
			case 3:

				List<Pedido> pedidos = pedidoRepositorio.findAll();

				for (Pedido p1 : pedidos) {
					System.out.println(p1);
				}

				break;
			case 4:

				String descripcion;
				int codigo;
				double precioUnitario;
				System.out.print("Ingrese código del producto: ");
				codigo = input.nextInt();
				System.out.print("Ingrese descripción del producto: ");
				descripcion = input.next();
				System.out.print("Ingrese precio del producto: ");
				precioUnitario = input.nextDouble();

				Producto c = new Producto(codigo, descripcion, precioUnitario);

				productoRepositorio.save(c);
				break;
			case 5:
				List<Producto> producto1 = productoRepositorio.findAll();

				for (Producto producto : producto1) {
					System.out.println(producto);
				}
				break;

			case 6:
				System.exit(0);

			default:
				System.out.println("Opción inválida, por favor seleccione otra");
				break;
			}
		}

	}

	public void insertarCliente(Cliente p) {
		try {
			clienteRepositorio.save(p);
		} catch (Exception e) {
			System.out.println("Error al insertar los datos");
		}
	}

	public void listarClientes() {
		List<Cliente> clientes = clienteRepositorio.findAll();

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}

	}

	public void generarPedido(int ids) {
		Cliente p = clienteRepositorio.findById(ids).get();

		Pedido fc = new Pedido();

		fc.setCliente(p);
		fc.setNumero(1001);
		fc.setFecha(new Date());
		fc.setPedidoDeLineas(null);

		pedidoRepositorio.save(fc);
	}

	public void recuperarFactura(int id) {
		try {
			Pedido pedido = pedidoRepositorio.findById(id).get();
			System.out.println(pedido);
		} catch (Exception e) {
			System.out.println("");
		}
	}

	public void findById(int id) {
		Producto producto = productoRepositorio.findById(id).get();
		System.out.println(producto);
	}
}
