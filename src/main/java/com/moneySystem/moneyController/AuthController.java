package com.moneySystem.moneyController;

import com.moneySystem.MoneyConfig.JwtUtil;
import com.moneySystem.moneyDTO.LoginDTO;
import com.moneySystem.moneyDTO.RegisterDTO;
import com.moneySystem.moneyEntity.User;
import com.moneySystem.moneyService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;  // Injeção correta do JwtUtil

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
        User newUser = authService.register(registerDTO);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = authService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Novo método refresh-token para gerar um token diretamente
    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestBody LoginDTO loginDTO) {
        // Opcional: Validar o email antes de gerar o token (pode consultar no banco de dados)
        String user = authService.login(loginDTO);

        // Gerar um novo token JWT baseado no email
        String newToken = jwtUtil.generateToken(user);

        // Retornar o novo token
        return ResponseEntity.ok(newToken);
    }


}

