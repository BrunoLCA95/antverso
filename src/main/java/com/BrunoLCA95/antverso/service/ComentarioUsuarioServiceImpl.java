package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.ComentarioUsuario;
import com.BrunoLCA95.antverso.repository.ComentarioUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ComentarioUsuarioServiceImpl extends GenericServiceImpl<ComentarioUsuario, Integer> implements ComentarioUsuarioService {
    @Autowired
    private ComentarioUsuarioRepository comentarioUsuarioRepository;

    @Override
    public CrudRepository<ComentarioUsuario, Integer> getDao(){
        return comentarioUsuarioRepository;
    }
}
