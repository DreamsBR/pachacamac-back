package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    // Métodos de consulta personalizados, si es necesario

    @Query("SELECT l FROM Login l WHERE l.usuario = :usuario AND l.contrasenia = :contrasenia")
    Optional<Login> findByUsuarioAndContrasenia(@Param("usuario") String usuario,
            @Param("contrasenia") String contrasenia);

    Login findByUsuario(String usuario);

}
