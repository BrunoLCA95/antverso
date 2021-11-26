package com.BrunoLCA95.antverso.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hormigas")
public class Hormiga {
    @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String nComun;

    private String nCientifico;

    private String descripcion;

    private String fotoReina;

    @ManyToOne
    private Temporada temporadaVN;

    private Integer tamanoReina;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Temporada getTemporadaVN() {
        return temporadaVN;
    }

    public void setTemporadaVN(Temporada temporadaVN) {
        this.temporadaVN = temporadaVN;
    }

    public Integer getTamanoReina() {
        return tamanoReina;
    }

    public void setTamanoReina(Integer tamanoReina) {
        this.tamanoReina = tamanoReina;
    }

    
}
