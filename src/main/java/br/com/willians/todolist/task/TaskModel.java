package br.com.willians.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id; // Identificador único da tarefa

    private String description; // Descrição da tarefa

    @Column(length = 50)
    private String title; // Título da tarefa

    private LocalDateTime startAt; // Data e hora de início da tarefa

    private LocalDateTime endAt; // Data e hora de término da tarefa

    private String priority; // Prioridade da tarefa

    private UUID idUser; // Identificador único do usuário associado à tarefa

    @CreationTimestamp
    private LocalDateTime createdAt; // Data e hora de criação da tarefa

    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O campo title deve ter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
