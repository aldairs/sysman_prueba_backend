package com.sistema.inventario.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "nombre_ciudad", length = 100)
    private String nombreCiudad;

    @Column(name = "nombre_departamento", length = 100)
    private String nombreDepartamento;


}
