package com.BrunoLCA95.antverso.repository;

import com.BrunoLCA95.antverso.entity.ComentarioUsuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioUsuarioRepository extends CrudRepository<ComentarioUsuario, Integer>{
    
}
