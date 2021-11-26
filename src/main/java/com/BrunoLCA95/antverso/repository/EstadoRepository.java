package com.BrunoLCA95.antverso.repository;
import com.BrunoLCA95.antverso.entity.Estado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer>{
    
}
