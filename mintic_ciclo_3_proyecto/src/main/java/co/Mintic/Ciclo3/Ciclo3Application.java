package co.Mintic.Ciclo3;


//import jdk.swing.interop.SwingInterOpUtils;
//import net.minidev.json.JSONUtil;
import co.Mintic.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {


	public static void main(String[] args) {

		SpringApplication.run(Ciclo3Application.class, args);
		System.out.println("Hello world");

	}
}
