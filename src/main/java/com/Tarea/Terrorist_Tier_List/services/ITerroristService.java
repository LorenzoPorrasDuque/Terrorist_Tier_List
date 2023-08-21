package com.Tarea.Terrorist_Tier_List.services;

import com.Tarea.Terrorist_Tier_List.models.Terrorist;

import java.util.List;

public interface ITerroristService {
    public List<Terrorist> findAll();

    public Terrorist findById(Long id);

    public void delete(Long id);

    public Terrorist save(Terrorist anime);


}
