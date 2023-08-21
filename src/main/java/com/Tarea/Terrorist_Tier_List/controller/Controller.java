package com.Tarea.Terrorist_Tier_List.controller;

import com.Tarea.Terrorist_Tier_List.models.Terrorist;
import com.Tarea.Terrorist_Tier_List.services.ITerroristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terrorist")
public class Controller {
    @Autowired
    private ITerroristService terroristService;

    @GetMapping("/lista")
    public List<Terrorist> terroristList() {
        return terroristService.findAll();
    }

    @GetMapping("/lista/{id}")
    public Terrorist terroristid(@PathVariable Long id) {
        return terroristService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        terroristService.delete(id);
    }

    @PostMapping("/add")
    public void addTerrorist(@RequestBody Terrorist terrorist) {
        terroristService.save(terrorist);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Terrorist terrorist) {
        Terrorist actual = terroristService.findById(id);
        if (actual != null) {
            actual.setNombre(terrorist.getNombre());
            actual.setKills(terrorist.getKills());
            actual.setCalificacion(terrorist.getCalificacion());
        }
        terroristService.save(actual);
    }


}
