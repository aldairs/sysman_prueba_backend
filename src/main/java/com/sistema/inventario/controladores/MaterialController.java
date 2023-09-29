package com.sistema.inventario.controladores;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.modelo.Material;
import com.sistema.inventario.repositorios.CiudadRepository;
import com.sistema.inventario.servicios.CiudadService;
import com.sistema.inventario.servicios.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private CiudadService ciudadService;



    @GetMapping("/todos")
    public List<Material> buscarTodosLosMateriales() {
        return materialService.buscarTodosLosMateriales();
    }

    @GetMapping("/tipo/{tipo}")
    public List<Material> buscarMaterialesPorTipo(@PathVariable String tipo) {
        return materialService.buscarMaterialesPorTipo(tipo);
    }

    @GetMapping("/fecha-compra/{fechaCompra}")
    public List<Material> buscarMaterialesPorFechaCompra(@PathVariable Date fechaCompra) {
        return materialService.buscarMaterialesPorFechaCompra(fechaCompra);
    }

    @GetMapping("/serial/{serial}")
    public List<Material> buscarMaterialesPorSerial(@PathVariable String serial) {
        return materialService.buscarMaterialesPorSerial(serial);
    }

    @GetMapping("/ciudad/{ciudadId}")
    public List<Material> buscarMaterialesPorCiudad(@PathVariable Long ciudadId) {
        // Aquí debes cargar la Ciudad desde tu repositorio o servicio Ciudad
        Optional<Ciudad> ciudad = Optional.ofNullable(ciudadService.buscarCiudadById(ciudadId));
        return materialService.buscarMaterialesPorCiudad(ciudad);
    }

    @PostMapping("/crear")
    public Material crearMaterial(@RequestBody Material material) {
        return materialService.crearMaterial(material);
    }

    @PutMapping("/actualizar/{id}")
    public Material actualizarMaterial(@PathVariable Long id, @RequestBody Material materialActualizado) {
        return materialService.actualizarMaterial(id, materialActualizado);
    }
}
