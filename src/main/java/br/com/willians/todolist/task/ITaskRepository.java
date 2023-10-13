package br.com.willians.todolist.task;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Importações necessárias para o código

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    // Interface ITaskRepository que estende JpaRepository para a entidade TaskModel

    // Método personalizado para buscar tarefas por ID de usuário
    List<TaskModel> findByIdUser(UUID idUser);
    
}