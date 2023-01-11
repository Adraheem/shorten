package com.shortenServer;

import com.shortenServer.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    private RoleService roleService;

    @Autowired
    public Main(RoleService roleService) {
        this.roleService = roleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public void populateDb(){
        String[] defaultRoles = {"USER", "ADMIN"};

        for (String role : defaultRoles ){
            roleService.createNewRole(role);
        }
    }
}
