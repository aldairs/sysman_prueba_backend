package com.sistema.inventario.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion" , length = 100)
    private String descripcion;

    @Column(name = "tipo" , length = 20)
    private String tipo;

    @Column(name = "serial" , length = 30)
    private String serial;

    @Column(name = "numero_interno" , length = 10)
    private Integer numeroInterno;

    @Column(name = "precio", columnDefinition = "NUMERIC(18,2)")
    private double precio;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "fecha_venta")
    private Date fechaVenta;

    //estado (activo, disponible, asignado),



    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoMaterial estado;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad; //(Entidad)

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
