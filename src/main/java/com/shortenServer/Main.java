package com.shortenServer;

import com.shortenServer.services.RoleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "URL Shortener",
                version = "v1",
                description = "This app provides REST APIs for URL shortener",
                contact = @Contact(
                        name = "Raheem Adebayo",
                        email = "adraheemzy@gmail.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "DEV Server"
                ),
                @Server(
                        url = "http://localhost:8080",
                        description = "PROD Server"
                )
        }
)
public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    private RoleService roleService;

    @Autowired
    public Main(RoleService roleService) {
        this.roleService = roleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        logger.info("App started successfully!");
    }

    @Bean
    public void populateDb() {
        String[] defaultRoles = {"USER", "ADMIN"};

        for (String role : defaultRoles) {
            roleService.createNewRole(role);
        }
    }
}
