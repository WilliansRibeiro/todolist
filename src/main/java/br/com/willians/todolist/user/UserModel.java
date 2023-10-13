package br.com.willians.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// Anotação @Entity indica que esta classe é uma entidade mapeada para uma tabela no banco de dados
@Data
@Entity(name = "tb_users")
public class UserModel {
    
    // Identificador único gerado automaticamente
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // Nome de usuário único
    @Column(unique = true)
    private String username;

    // Nome do usuário
    private String name;

    // Senha do usuário
    private String password;

    // Data e hora de criação do usuário, anotada com @CreationTimestamp
    @CreationTimestamp
    private LocalDateTime createdAt;
}
