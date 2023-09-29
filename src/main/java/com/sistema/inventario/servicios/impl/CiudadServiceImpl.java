package com.sistema.inventario.servicios.impl;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.repositorios.CiudadRepository;
import com.sistema.inventario.servicios.CiudadService;
import com.sistema.inventario.servicios.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;



    @Override
    public Ciudad buscarCiudadById(Long id) {
        return  this.ciudadRepository.findById(id).get();
    }

}
