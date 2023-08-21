package com.Tarea.Terrorist_Tier_List.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
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


}
