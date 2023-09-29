package com.sistema.inventario;

import com.sistema.inventario.excepciones.UsuarioFoundException;
import com.sistema.inventario.modelo.*;
import com.sistema.inventario.repositorios.CiudadRepository;
import com.sistema.inventario.repositorios.EstadoMaterialRepository;
import com.sistema.inventario.repositorios.MaterialReporsity;
import com.sistema.inventario.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@SpringBootApplication
public class SistemaInventarioBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EstadoMaterialRepository estadoMaterialRepository ;

	@Autowired
	private  CiudadRepository ciudadRepository;

	@Autowired
	private MaterialReporsity materialRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaInventarioBackendApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


			
			//Insertamos los estado solicitado en la prueba.

		/*EstadoMaterial estadoActivo = new EstadoMaterial();
		estadoActivo.setNombre("Activo");
		estadoActivo.setDescripcion("Material en estado activo");

		EstadoMaterial estadoDisponible = new EstadoMaterial();
		estadoDisponible.setNombre("Disponible");
		estadoDisponible.setDescripcion("Material en estado disponible");

		EstadoMaterial estadoAsignado = new EstadoMaterial();
		estadoAsignado.setNombre("Asignado");
		estadoAsignado.setDescripcion("Material en estado asignado");

		estadoMaterialRepository.save(estadoActivo);
		estadoMaterialRepository.save(estadoDisponible);
		estadoMaterialRepository.save(estadoAsignado);*/

//Insertamos usuario admin.
/*
			try{
				Usuario usuario = new Usuario();

				usuario.setNombre("Aldair");
				usuario.setApellido("Segura");
				usuario.setUsername("asegura");
				usuario.setPassword(bCryptPasswordEncoder.encode("123456789"));
				usuario.setEmail("aldair.jsm@gmail.com");
				usuario.setTelefono("3015312232");
				usuario.setPerfil("foto.png");

				Rol rol = new Rol();
				rol.setRolId(1L);
				rol.setRolNombre("ADMIN");

				Set<UsuarioRol> usuariosRoles = new HashSet<>();
				UsuarioRol usuarioRol = new UsuarioRol();
				usuarioRol.setRol(rol);
				usuarioRol.setUsuario(usuario);
				usuariosRoles.add(usuarioRol);

				Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
				System.out.println(usuarioGuardado.getUsername());
			}catch(UsuarioFoundException exception){
				exception.printStackTrace();
			}
*/
			//insercion inicial ciudades 10 ciudades principales.

	/*	List<Ciudad> ciudades = new ArrayList<>();

		Ciudad ciudad1 = new Ciudad();
		ciudad1.setNombre("Bogotá");
		ciudad1.setNombreCiudad("Bogotá D.C.");
		ciudad1.setNombreDepartamento("Bogotá D.C.");
		ciudades.add(ciudad1);

		Ciudad ciudad2 = new Ciudad();
		ciudad2.setNombre("Medellín");
		ciudad2.setNombreCiudad("Medellín");
		ciudad2.setNombreDepartamento("Antioquia");
		ciudades.add(ciudad2);

		Ciudad ciudad3 = new Ciudad();
		ciudad3.setNombre("Cali");
		ciudad3.setNombreCiudad("Cali");
		ciudad3.setNombreDepartamento("Valle del Cauca");
		ciudades.add(ciudad3);

		Ciudad ciudad4 = new Ciudad();
		ciudad4.setNombre("Barranquilla");
		ciudad4.setNombreCiudad("Barranquilla");
		ciudad4.setNombreDepartamento("Atlántico");
		ciudades.add(ciudad4);

		Ciudad ciudad5 = new Ciudad();
		ciudad5.setNombre("Cartagena");
		ciudad5.setNombreCiudad("Cartagena");
		ciudad5.setNombreDepartamento("Bolívar");
		ciudades.add(ciudad5);

		Ciudad ciudad6 = new Ciudad();
		ciudad6.setNombre("Cúcuta");
		ciudad6.setNombreCiudad("Cúcuta");
		ciudad6.setNombreDepartamento("Norte de Santander");
		ciudades.add(ciudad6);

		Ciudad ciudad7 = new Ciudad();
		ciudad7.setNombre("Bucaramanga");
		ciudad7.setNombreCiudad("Bucaramanga");
		ciudad7.setNombreDepartamento("Santander");
		ciudades.add(ciudad7);

		Ciudad ciudad8 = new Ciudad();
		ciudad8.setNombre("Pereira");
		ciudad8.setNombreCiudad("Pereira");
		ciudad8.setNombreDepartamento("Risaralda");
		ciudades.add(ciudad8);

		Ciudad ciudad9 = new Ciudad();
		ciudad9.setNombre("Santa Marta");
		ciudad9.setNombreCiudad("Santa Marta");
		ciudad9.setNombreDepartamento("Magdalena");
		ciudades.add(ciudad9);

		Ciudad ciudad10 = new Ciudad();
		ciudad10.setNombre("Ibagué");
		ciudad10.setNombreCiudad("Ibagué");
		ciudad10.setNombreDepartamento("Tolima");
		ciudades.add(ciudad10);





		ciudadRepository.saveAll(ciudades);*/

		//insertamos algunos materiales para data inicial
		/*EstadoMaterial estadoActivo = estadoMaterialRepository.findById(1L).get();


		//restamos un dia de la fecha de hoy para la compra y hacemos validacion de fecha
		// Obtenemos la fecha actual
		Calendar cal = Calendar.getInstance();
		Date fechaActual = cal.getTime();

// Resta un día
		cal.setTime(fechaActual);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date fechaUnDiaMenos = cal.getTime();

		for (int i = 1; i <= 5; i++) {
			Material material = new Material();
			material.setNombre("Material " + i);
			material.setDescripcion("Descripción del Material " + i);
			material.setTipo("Tipo " + i);
			material.setSerial("Serial " + i);
			material.setNumeroInterno(i);
			material.setPrecio(100.0 * i);
			material.setFechaCompra(fechaUnDiaMenos);
			material.setFechaVenta(fechaActual);
			material.setEstado(estadoActivo); // Asigna el estado, puedes crear más estados según sea necesario
			material.setCiudad(this.ciudadRepository.getById((long) (i+1)));
			// Validación de fechas
			if (material.getFechaCompra().after(material.getFechaVenta())) {
				throw new IllegalArgumentException("La fecha de compra debe ser anterior a la fecha de venta.");
			}

			materialRepository.save(material); // Guarda el material en la base de datos
		}
*/

	}
}
