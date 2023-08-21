package com.Tarea.Terrorist_Tier_List.services;

import com.Tarea.Terrorist_Tier_List.dao.ITerroristDAO;
import com.Tarea.Terrorist_Tier_List.models.Terrorist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerroristService implements ITerroristService {
    @Autowired
    private ITerroristDAO TerroristDAO;

    @Override
    public List<Terrorist> findAll() {
        return TerroristDAO.findAll();
    }

    @Override
    public Terrorist findById(Long id) {
        return TerroristDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        TerroristDAO.deleteById(id);
    }

    @Override
    public Terrorist save(Terrorist anime) {
        return TerroristDAO.save(anime);
    }
}
