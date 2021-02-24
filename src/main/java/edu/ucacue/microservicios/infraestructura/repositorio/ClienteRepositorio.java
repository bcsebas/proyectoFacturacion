package edu.ucacue.microservicios.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucacue.microservicios.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByNombre(String nombre);

}
