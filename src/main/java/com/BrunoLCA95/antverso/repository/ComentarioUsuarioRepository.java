package com.BrunoLCA95.antverso.repository;

import java.util.List;

import com.BrunoLCA95.antverso.entity.ComentarioUsuario;
import com.BrunoLCA95.antverso.entity.Hormiga;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioUsuarioRepository extends CrudRepository<ComentarioUsuario, Integer>{
    
    @Query("SELECT a FROM ComentarioUsuario a WHERE a.hormiga = :hormiga")
    public List<ComentarioUsuario> findByHormiga(@Param("hormiga") Hormiga hormiga);


}
