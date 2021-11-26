package com.BrunoLCA95.antverso.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    private Integer id;

    @ManyToOne
    private Pais idPais;

    private String estadonombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    public String getEstadonombre() {
        return estadonombre;
    }

    public void setEstadonombre(String estadonombre) {
        this.estadonombre = estadonombre;
    }


    
}
