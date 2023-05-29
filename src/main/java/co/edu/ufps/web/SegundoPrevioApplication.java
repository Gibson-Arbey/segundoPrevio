package co.edu.ufps.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "co.edu.ufps.web")
public class SegundoPrevioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegundoPrevioApplication.class, args);
		System.out.println("Compila");
	}

}
