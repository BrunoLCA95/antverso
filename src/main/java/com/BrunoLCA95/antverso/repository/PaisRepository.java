package com.BrunoLCA95.antverso.repository;

import com.BrunoLCA95.antverso.entity.Pais;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaisRepository extends CrudRepository<Pais, Integer>{
    
    @Query("SELECT a FROM Pais a WHERE a.id = :id")
    public Pais buscarPais (@Param("id") Integer id);
}
