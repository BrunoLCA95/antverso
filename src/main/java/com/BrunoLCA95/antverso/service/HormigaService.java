package com.BrunoLCA95.antverso.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.BrunoLCA95.antverso.commons.WebExeption;
import com.BrunoLCA95.antverso.entity.ComentarioUsuario;
import com.BrunoLCA95.antverso.entity.Hormiga;
import com.BrunoLCA95.antverso.repository.HormigaRepository;

import org.sonatype.restsimple.client.WebException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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


    public Hormiga saveImg(MultipartFile file, Hormiga hormiga) throws WebExeption{
        if (!file.isEmpty()) {
            Path directorioImg = Paths.get("src//main//resources//static/img/reinas");
            String rutaAbs = directorioImg.toFile().getAbsolutePath();
            
            try {
                byte[] bytesImg = file.getBytes();
                Path rutaCompleta = Paths.get(rutaAbs + "//" + file.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                hormiga.setFotoReina(file.getOriginalFilename());
                return hormiga;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            throw new WebExeption("Asegurece que la imagen cumpla con los requisitos");
        }

        return hormiga;
   
    }

}
