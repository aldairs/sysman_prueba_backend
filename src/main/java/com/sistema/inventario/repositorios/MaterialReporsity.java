package com.sistema.inventario.repositorios;

import com.sistema.inventario.modelo.Ciudad;
import com.sistema.inventario.modelo.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MaterialReporsity extends JpaRepository<Material, Long> {

    List<Material> findByTipo(String tipo);

    List<Material> findByFechaCompra(Date fechaCompra);

    List<Material> findBySerial(String serial);

    List<Material> findByCiudad(Ciudad ciudad);


}
