package com.practica01.service;

import com.practica01.dao.EstadoDao;
import com.practica01.domain.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    EstadoDao estadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> getEstados() {
        return (List<Estado>) estadoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estado getEstado(Estado estado) {
        return estadoDao.findById(estado.getIdEstado()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Estado estado) {
        estadoDao.save(estado);
    }
    
    @Override
    @Transactional
    public void delete(Estado estado) {
        estadoDao.deleteById(estado.getIdEstado());
    }
    
}
