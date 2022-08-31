package co.Mintic.Ciclo3;

import co.Mintic.Ciclo3.modelos.Empresa;
import net.bytebuddy.build.ToStringPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public String hello(){

		return "Hello world";
	}

	@GetMapping("/test")
	public String test(){
		Empresa company = new Empresa("Morfo-Clothing", "Carrera 29 # 78 01", "3507023133", "1013605223");

		return company.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
