package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.Estado;
import com.BrunoLCA95.antverso.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl extends GenericServiceImpl<Estado, Integer> implements EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public CrudRepository<Estado, Integer> getDao() {
        return estadoRepository;
    }

}