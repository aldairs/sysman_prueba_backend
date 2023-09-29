package com.sistema.inventario.repositorios;
import com.sistema.inventario.modelo.EstadoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoMaterialRepository extends JpaRepository<EstadoMaterial, Long>{

}
