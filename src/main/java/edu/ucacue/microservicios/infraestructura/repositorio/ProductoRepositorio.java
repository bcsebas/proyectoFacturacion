package edu.ucacue.microservicios.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucacue.microservicios.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
	
	Producto findByDescripcion(String descripcion);

}
