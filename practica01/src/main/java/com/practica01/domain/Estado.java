package com.practica01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="estado")
public class Estado {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;
    String pais;
    String capital;
    String poblacion;
    String costas;

    public Estado() {
    }

    public Estado(String pais, String capital, String poblacion, String costas) {
        this.pais = pais;
        this.capital = capital;
        this.poblacion = poblacion;
        this.costas = costas;
    }
}

