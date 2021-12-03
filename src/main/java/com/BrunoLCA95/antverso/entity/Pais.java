package com.BrunoLCA95.antverso.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    private Integer id;
    private String paisnombre;

    @OneToMany
    private List<Estado> estados;

    

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPaisnombre() {
        return paisnombre;
    }



    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }



    public List<Estado> getEstados() {
        return estados;
    }



    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }



       
}
