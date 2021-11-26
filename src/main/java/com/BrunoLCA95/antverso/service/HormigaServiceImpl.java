package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.repository.HormigaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class HormigaServiceImpl extends GenericServiceImpl<Hormiga, String> implements HormigaService{
   
    @Autowired
    private HormigaRepository hormigaRepository;

    @Override
    public CrudRepository<Hormiga, String> getDao(){
        return hormigaRepository;
    }


    
}
