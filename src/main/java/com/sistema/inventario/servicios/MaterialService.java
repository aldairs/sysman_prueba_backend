package com.sistema.inventario.servicios;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.modelo.Material;

import java.util.Date;
import java.util.List;

public interface MaterialService {

    List<Material> buscarTodosLosMateriales();

    List<Material> buscarMaterialesPorTipo(String tipo);

    List<Material> buscarMaterialesPorFechaCompra(Date fechaCompra);

    List<Material> buscarMaterialesPorSerial(String serial);

    List<Material> buscarMaterialesPorCiudad(Ciudad ciudad);

    Material crearMaterial(Material material);

    Material actualizarMaterial(Long id, Material materialActualizado);
}













