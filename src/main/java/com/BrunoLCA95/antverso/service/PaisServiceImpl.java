package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.Pais;
import com.BrunoLCA95.antverso.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl extends GenericServiceImpl<Pais, Integer> implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public CrudRepository<Pais, Integer> getDao(){
        return paisRepository;
    }
    
}
