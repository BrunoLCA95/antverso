package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.Temporada;
import com.BrunoLCA95.antverso.repository.TemporadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TemporadaServiceImpl extends GenericServiceImpl<Temporada, Integer> implements TemporadaService {
    
    @Autowired
    private TemporadaRepository temporadaRepository;

    @Override
    public CrudRepository<Temporada, Integer> getDao(){
        return temporadaRepository;
    }


}
