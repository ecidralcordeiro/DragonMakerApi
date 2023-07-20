package com.uextest.contoller;

import com.uextest.model.User;
import com.uextest.service.UserServiceimpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UserServiceimpl repository;
    private final String encoder;

    public UsuarioController(UserServiceimpl repository, String password) {
        this.repository = repository;
        this.encoder = password;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<User>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }



    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<User> optUsuario = Optional.ofNullable(repository.findByUsername(login));
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User usuario = optUsuario.get();
        boolean valid = encoder.matches(password);

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}