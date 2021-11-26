package com.BrunoLCA95.antverso.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    private Integer id;
    private String paisnombre;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPaisnombre() {
        return paisnombre;
    }
    public void setPaisnombre(String paisnombre) {
        this.paisnombre = paisnombre;
    }

    
}
