package br.com.willians.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    // Método para criar um novo usuário
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        // Verifica se o usuário já existe com base no nome de usuário
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {
            // Se o usuário já existe, retorna um erro de solicitação inválida
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USUÁRIO JÁ EXISTE!!");
        }

        // Criptografa a senha do usuário usando BCrypt
        var passwordHashed =  BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashed);

        // Salva o usuário criado no repositório
        var userCreated = this.userRepository.save(userModel);

        // Retorna uma resposta de sucesso com o usuário criado
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
