package com.sistema.inventario.repositorios;

import com.sistema.inventario.modelo.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    @Override
     Optional<Ciudad> findById(Long aLong);
}
