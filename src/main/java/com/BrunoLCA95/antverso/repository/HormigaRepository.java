package com.BrunoLCA95.antverso.repository;

import java.util.List;

import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.entity.Pais;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HormigaRepository extends CrudRepository<Hormiga, Integer>{
    
    @Query("SELECT a FROM Hormiga a WHERE a.nCientifico = :nCientifico")
    public Hormiga findByNCientifico(@Param("nCientifico")String nCientifico);

    @Query("SELECT a FROM Hormiga a WHERE a.pais = :pais")
    public List<Hormiga> buscarPorPais(@Param("pais") Pais pais);

    @Query("SELECT a FROM Hormiga a WHERE a.id = :id")
    public Hormiga buscarPorId(@Param("id")Integer id);

    
}
