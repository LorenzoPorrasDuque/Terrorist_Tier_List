package com.Tarea.Terrorist_Tier_List.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "group")
public class Group implements Comparable<Terrorist>, Serializable {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Override
    public int compareTo(Terrorist o) {
        return 0;
    }
}
