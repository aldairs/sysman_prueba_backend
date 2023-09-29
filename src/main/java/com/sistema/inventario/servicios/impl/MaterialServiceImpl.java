package com.sistema.inventario.servicios.impl;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.modelo.Material;
import com.sistema.inventario.repositorios.MaterialReporsity;
import com.sistema.inventario.servicios.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialReporsity materialRepository;




    @Override
    public List<Material> buscarTodosLosMateriales() {
        return materialRepository.findAll();
    }

    @Override
    public List<Material> buscarMaterialesPorTipo(String tipo) {
        return materialRepository.findByTipo(tipo);
    }

    @Override
    public List<Material> buscarMaterialesPorFechaCompra(Date fechaCompra) {
        return materialRepository.findByFechaCompra(fechaCompra);
    }

    @Override
    public List<Material> buscarMaterialesPorSerial(String serial) {
        return materialRepository.findBySerial(serial);
    }

    @Override
    public List<Material> buscarMaterialesPorCiudad(Optional<Ciudad> ciudad) {
        return materialRepository.findByCiudad(ciudad);
    }

    @Override
    public Material crearMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material actualizarMaterial(Long id, Material materialActualizado) {
        Material materialExistente = materialRepository.findById(id).orElse(null);
        if (materialExistente != null) {
            // Actualiza los campos necesarios
            materialExistente.setTipo(materialActualizado.getTipo());
            materialExistente.setFechaCompra(materialActualizado.getFechaCompra());
            materialExistente.setSerial(materialActualizado.getSerial());
            // Actualiza otros campos aquí según tus necesidades

            // Guarda el material actualizado
            return materialRepository.save(materialExistente);
        } else {
            return null; // Material no encontrado
        }
    }
}

