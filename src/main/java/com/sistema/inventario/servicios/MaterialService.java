package com.sistema.inventario.servicios;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.modelo.Material;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MaterialService {

    List<Material> buscarTodosLosMateriales();

    List<Material> buscarMaterialesPorTipo(String tipo);

    List<Material> buscarMaterialesPorFechaCompra(Date fechaCompra);

    List<Material> buscarMaterialesPorSerial(String serial);

    List<Material> buscarMaterialesPorCiudad(Optional<Ciudad> ciudad);

    Material crearMaterial(Material material);

    Material actualizarMaterial(Long id, Material materialActualizado);
}













