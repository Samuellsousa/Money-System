package com.moneySystem.moneyService;

import com.moneySystem.moneyDTO.LoginDTO;
import com.moneySystem.moneyDTO.RegisterDTO;
import com.moneySystem.moneyEntity.User;
import com.moneySystem.moneyRepository.UserRepository;
import com.moneySystem.MoneyConfig.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // O bean de PasswordEncoder será injetado aqui

    @Autowired
    private JwtUtil jwtUtil;

    public User register(RegisterDTO registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));  // Usa o PasswordEncoder para criptografar a senha
        user.setName(registerDTO.getName());
        return userRepository.save(user);
    }

    public String login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            // Gerar token JWT e retornar
            return jwtUtil.generateToken(user.getEmail());
        } else {
            throw new BadCredentialsException("Senha incorreta");
        }
    }

    public User getCurrentUser() {
        return null;
    }

    public List<User> getAllUsers() {
        return List.of();
    }
}

