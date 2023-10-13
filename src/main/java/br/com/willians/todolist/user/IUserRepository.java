package br.com.willians.todolist.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que estende JpaRepository para operações relacionadas a usuários
public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    // Método personalizado para buscar um usuário pelo nome de usuário
    UserModel findByUsername(String username);
}
