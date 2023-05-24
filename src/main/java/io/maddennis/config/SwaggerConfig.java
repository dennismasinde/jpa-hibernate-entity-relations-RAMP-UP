package io.maddennis.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Entity Relations Ramp Up",
                version = "1.0.0",
                description = """
                        Endpoints documentation.\n
                        Available endpoints
                        """
        ),
        servers= {
                @Server(
                        url="http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}
