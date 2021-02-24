package edu.ucacue.microservicios;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import edu.ucacue.microservicios.controlador.Principal;



@SpringBootApplication
public class MicroserviciosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = new SpringApplicationBuilder(MicroserviciosApplication.class).headless(false)
				.web(WebApplicationType.NONE).run(args);
		Principal principal = contexto.getBean(Principal.class);

		principal.interfaz();

	}

}
