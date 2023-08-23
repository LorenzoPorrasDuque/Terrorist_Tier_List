package com.Tarea.Terrorist_Tier_List.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "data")
public class Terrorist implements Comparable<Terrorist>, Serializable {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @Column
    private String nombre;
    @Getter
    @Setter
    @Column
    private int kills;
    @Getter
    @Setter
    @Column
    private double calificacion;


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKills() {
        return kills;
    }

    public double getCalificacion() {
        return calificacion;
    }


    @Override
    public int compareTo(Terrorist e) {
        // TODO Auto-generated method stub
        return this.getKills() - e.getKills();
    }

}
