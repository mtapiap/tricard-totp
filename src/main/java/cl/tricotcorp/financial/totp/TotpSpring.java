package cl.tricotcorp.financial.totp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info=@Info(title="TOTP Tricot", version="1.0", description = "Servicio generador de TOTP para Tricot"))

@SpringBootApplication
public class TotpSpring {

	public static void main(String[] args) {
		SpringApplication.run(TotpSpring.class, args);
	}

}
