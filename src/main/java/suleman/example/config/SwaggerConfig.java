package suleman.example.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration

@OpenAPIDefinition(
	info = @Info(title = "Employee Management API ",
	version = "1.0",
	description = "REST API for managing employees"
	)
)
public class SwaggerConfig {

	

}
