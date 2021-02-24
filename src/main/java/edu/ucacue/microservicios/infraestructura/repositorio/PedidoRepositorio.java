package edu.ucacue.microservicios.infraestructura.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucacue.microservicios.modelo.Pedido;


public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
	
}
