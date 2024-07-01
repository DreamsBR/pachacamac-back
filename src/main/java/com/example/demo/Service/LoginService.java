package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Login;
import com.example.demo.Repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public Login autentificar(String usario, String contrasenia) {
        Optional<Login> opcional = loginRepository.findByUsuarioAndContrasenia(usario, contrasenia);
        return opcional.orElse(null); // Retorna el usuario si existe, o null si no se encontró uno.
    }

    public void guardarUsuario(Login login) {
        loginRepository.save(login);
    }

    public Login crearUsuario(Login login) {
        if (loginRepository.findByUsuario(login.getUsuario()) != null) {
            throw new IllegalArgumentException("Usario ya registrado");
        }
        return loginRepository.save(login);
    }
}