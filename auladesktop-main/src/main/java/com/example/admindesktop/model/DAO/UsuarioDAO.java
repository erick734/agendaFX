package com.example.admindesktop.model.DAO;

import com.example.admindesktop.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDAO {

    private EntityManager entityManager;

    public UsuarioDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void salvar(Usuario usuario) {
        this.entityManager.persist(usuario);
    }
}