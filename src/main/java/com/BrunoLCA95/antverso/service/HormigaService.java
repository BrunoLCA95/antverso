package com.BrunoLCA95.antverso.service;

import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.repository.HormigaRepository;

import org.sonatype.restsimple.client.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HormigaService{
    
    @Autowired
    private HormigaRepository hormigaRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { WebException.class, Exception.class })
    public Hormiga save(Hormiga hormiga) throws WebExeption{

        validation(hormiga);
        return hormigaRepository.save(hormiga);

    }

    public void validation(Hormiga hormiga) throws WebExeption{
        if (hormigaRepository.findByNCientifico(hormiga.getnCientifico()) != null ) {
            throw new WebExeption("La hormiga ya se encuentra cargada");
        }
    }

  

}
