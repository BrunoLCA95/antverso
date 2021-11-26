package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.GenericServiceImpl;
import com.BrunoLCA95.antverso.entity.Usuario;
import com.BrunoLCA95.antverso.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao(){
        return usuarioRepository;
    }

}
