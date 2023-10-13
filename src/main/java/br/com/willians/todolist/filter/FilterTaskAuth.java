package br.com.willians.todolist.filter;

import br.com.willians.todolist.user.IUserRepository;

import java.io.IOException;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Obtém o caminho da servlet da requisição
        var servletPath = request.getServletPath();
        
        // Verifica se o caminho da requisição começa com "/tasks/"
        if (servletPath.startsWith("/tasks/")) {
            
            // Pega a autenticação (usuário e senha) do cabeçalho "Authorization"
            var authorization = request.getHeader("Authorization");
            var authencoded = authorization.substring("Basic".length()).trim();
            byte[] authDecoded = Base64.getDecoder().decode(authencoded);
            String authString = new String(authDecoded);

            // Divide as credenciais em usuário e senha
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Valida a senha do usuário
            var user = userRepository.findByUsername(username);
            if (user == null) {
                // Se o usuário não for encontrado, retorna um erro de autorização
                response.sendError(HttpStatus.UNAUTHORIZED.value());
            } else {
                var passwordVerified = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerified.verified) {
                    // Se a senha estiver correta, define o atributo "idUser" na requisição com o ID do usuário
                    request.setAttribute("idUser", user.getId());
                    // Permite que a requisição siga seu curso
                    filterChain.doFilter(request, response);
                } else {
                    // Se a senha estiver incorreta, retorna um erro de autorização
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                }
            }
        } else {
            // Se o caminho da requisição não começa com "/tasks/", permite que a requisição siga seu curso
            filterChain.doFilter(request, response);
        }
    }
}
