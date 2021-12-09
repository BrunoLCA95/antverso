package com.BrunoLCA95.antverso.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
@Table(name = "hormigas")
public class Hormiga implements Serializable{

    private static final long serialVersionUID = 6522896498689132123L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nComun;

    private String nCientifico;

    private String descripcion;

    private String fotoReina;

    private String tamanoReina;

    @ManyToMany
    private List<Pais> pais;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnComun() {
        return nComun;
    }

    public void setnComun(String nComun) {
        this.nComun = nComun;
    }

    public String getnCientifico() {
        return nCientifico;
    }

    public void setnCientifico(String nCientifico) {
        this.nCientifico = nCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoReina() {
        return fotoReina;
    }

    public void setFotoReina(String fotoReina) {
        this.fotoReina = fotoReina;
    }

    public String getTamanoReina() {
        return tamanoReina;
    }

    public void setTamanoReina(String tamanoReina) {
        this.tamanoReina = tamanoReina;
    }

    public List<Pais> getPais() {
        return pais;
    }

    public void setPais(List<Pais> pais) {
        this.pais = pais;
    }
    
}
