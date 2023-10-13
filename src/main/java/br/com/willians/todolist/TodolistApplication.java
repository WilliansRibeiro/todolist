package br.com.willians.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que indica que esta classe é a classe principal da aplicação Spring Boot
@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
        // Método principal, que inicia a execução da aplicação Spring Boot
        SpringApplication.run(TodolistApplication.class, args);
        // Aqui, estamos iniciando a aplicação Spring Boot com esta classe e quaisquer argumentos da linha de comando (args).
    }
}
