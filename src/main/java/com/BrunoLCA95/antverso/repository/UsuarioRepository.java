package com.BrunoLCA95.antverso.repository;

import com.BrunoLCA95.antverso.entity.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
