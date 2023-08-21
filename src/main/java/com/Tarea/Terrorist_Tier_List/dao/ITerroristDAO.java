package com.Tarea.Terrorist_Tier_List.dao;

import com.Tarea.Terrorist_Tier_List.models.Terrorist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITerroristDAO extends JpaRepository<Terrorist, Long> {

}
