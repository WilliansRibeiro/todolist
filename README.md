# todolist #Portugues
Aplicação Spring para Gerenciamento de Tarefas e Usuários

# Descrição
Este projeto é uma aplicação Spring Boot que oferece funcionalidades de gerenciamento de tarefas (tasks) e usuários. A aplicação inclui controladores, repositórios e modelos que possibilitam a criação, listagem e atualização de tarefas, bem como a criação de usuários.

# Funcionalidades
A aplicação inclui os seguintes componentes e funcionalidades:

## Modelo de Tarefa (TaskModel)
- A classe `TaskModel` representa o modelo de uma tarefa e mapeia os atributos de uma tarefa no banco de dados.
- Atributos incluem ID único, descrição, título, data de início, data de término, prioridade, ID do usuário associado e data de criação.

## Modelo de Usuário (UserModel)
- A classe `UserModel` representa o modelo de usuário e mapeia os atributos de um usuário no banco de dados.
- Atributos incluem ID único, nome de usuário, nome, senha e data de criação.

## Repositórios de Tarefas e Usuários
- Foram criadas interfaces de repositório (`ITaskRepository` e `IUserRepository`) que estendem `JpaRepository` para operações de acesso e consulta relacionadas a tarefas e usuários.

## Controladores
- O controlador `TaskController` oferece endpoints para criar, listar e atualizar tarefas.
- O controlador `UserController` oferece endpoints para criar usuários.

## Filtro de Autenticação
- O filtro `FilterTaskAuth` autentica solicitações relacionadas a tarefas com base nas credenciais de usuário e senha fornecidas no cabeçalho "Authorization".

# Uso
Para utilizar esta aplicação, é necessário configurar um ambiente de desenvolvimento Spring Boot e um banco de dados compatível. A aplicação permite criar tarefas, listar tarefas associadas a um usuário, criar usuários e autenticar solicitações de tarefas.

# Requisitos
Certifique-se de ter configurado um ambiente Spring Boot e um banco de dados compatível antes de executar a aplicação. A aplicação também faz uso da biblioteca BCrypt para criptografar senhas de usuários.

# Observações
Este README compila informações com base nos códigos fornecidos. Certifique-se de adequar o uso da aplicação à sua necessidade específica e configurar outros aspectos, como segurança e autorização, conforme necessário.

**Atenção:** O código é fornecido apenas como exemplo e pode precisar de ajustes ou aprimoramentos adicionais, dependendo das necessidades da sua aplicação.







# TodoList english
Spring Application for Task and User Management

# Description
This project is a Spring Boot application that offers task and user management functionalities. The application includes controllers, repositories, and models that enable the creation, listing, and updating of tasks, as well as user creation.

# Features
The application includes the following components and features:

## Task Model (TaskModel)
- The `TaskModel` class represents the model of a task and maps the attributes of a task in the database.
- Attributes include a unique ID, description, title, start date, end date, priority, associated user ID, and creation date.

## User Model (UserModel)
- The `UserModel` class represents the model of a user and maps the attributes of a user in the database.
- Attributes include a unique ID, username, name, password, and creation date.

## Task and User Repositories
- Custom repository interfaces (`ITaskRepository` and `IUserRepository`) were created, extending `JpaRepository` for data access and query operations related to tasks and users.

## Controllers
- The `TaskController` provides endpoints for creating, listing, and updating tasks.
- The `UserController` offers endpoints for creating users.

## Authentication Filter
- The `FilterTaskAuth` filter authenticates requests related to tasks based on user credentials provided in the "Authorization" header.

# Usage
To use this application, you need to set up a Spring Boot development environment and a compatible database. The application allows you to create tasks, list tasks associated with a user, create users, and authenticate task requests.

# Requirements
Make sure to have a Spring Boot development environment and a compatible database set up before running the application. The application also uses the BCrypt library to encrypt user passwords.

# Notes
This README compiles information based on the provided code. Ensure that you tailor the application's use to your specific needs and configure other aspects, such as security and authorization, as necessary.

**Note:** The code is provided as an example and may require additional adjustments or enhancements depending on your application's requirements.

