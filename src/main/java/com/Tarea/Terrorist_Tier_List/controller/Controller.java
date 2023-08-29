package com.Tarea.Terrorist_Tier_List.controller;

import com.Tarea.Terrorist_Tier_List.models.Terrorist;
import com.Tarea.Terrorist_Tier_List.services.ITerroristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/terrorist")
public class Controller {
    @Autowired
    private ITerroristService terroristService;

    @GetMapping("/lista")
    public List<Terrorist> terroristList() {
        List<Terrorist> lista = terroristService.findAll();
        lista.sort(Comparator.comparing(Terrorist::getKills));
        return lista;
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> terroristid(@PathVariable Long id) {
        Terrorist terrorist = terroristService.findById(id);
        Map<String, String> respone = new HashMap<>();
        if (terrorist == null) {
            respone.put("Mensaje", "El terrorista con id " + id + " no existe");
            return new ResponseEntity<Map<String, String>>(respone, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Terrorist>(terrorist, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        terroristService.delete(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addTerrorist(@Valid @RequestBody Terrorist terrorist, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        Terrorist lord = null;
        if (result.hasErrors()) {
            List<String> error = new ArrayList<>();
            for (FieldError err : result.getFieldErrors()) {
                error.add("el campo" + err.getField() + " " + err.getDefaultMessage());
            }
            response.put("Errors", error);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            lord = terroristService.save(terrorist);
        } catch (Exception e) {
            response.put("mensaje", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Terrorist>(lord, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Terrorist update(@PathVariable Long id, @RequestBody Terrorist terrorist) {
        Terrorist actual = terroristService.findById(id);
        if (actual != null) {
            actual.setNombre(terrorist.getNombre());
            actual.setKills(terrorist.getKills());
            actual.setCalificacion(terrorist.getCalificacion());
        }
        return terroristService.save(actual);
    }
}
