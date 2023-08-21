package com.Tarea.Terrorist_Tier_List.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;


@Entity
@Table(name = "data")
public class Terrorist implements Comparable<Terrorist>, Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column
    private String nombre;
    @Getter
    @Column
    private int kills;
    @Getter
    @Column
    private double calificacion;

    public Long getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int compareTo(Terrorist o) {
        return 0;
    }
}
