package com.Estado.dao;

import com.Estado.domain.Estado;
import org.springframework.data.repository.CrudRepository;


public interface EstadoDao extends CrudRepository<Estado, Long>{
    
}