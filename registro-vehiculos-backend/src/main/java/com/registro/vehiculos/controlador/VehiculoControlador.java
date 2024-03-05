package com.registro.vehiculos.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.vehiculos.excepciones.ResourceNotFoundException;
import com.registro.vehiculos.modelo.Vehiculo;
import com.registro.vehiculos.repositorio.VehiculoRepositorio;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class VehiculoControlador {

	@Autowired
	private VehiculoRepositorio repositorio;
	
	//este metodo sirve para listar todos los vehiculos
	@GetMapping("/vehiculos")
	public List<Vehiculo> listarTodosLosVehiculos() {
		return repositorio.findAll();
	}
	
	//este metodo sirve para guardar el vehiculo
	@PostMapping("/vehiculos")
	public Vehiculo guardarVehiculo(@RequestBody Vehiculo vehiculo) {
		return repositorio.save(vehiculo);
	}
	
	//este metodo sirve para buscar un vehiculo
	@GetMapping("/vehiculos/{id}")
	public ResponseEntity<Vehiculo> obtenerVehiculoPorId(@PathVariable Long id){
		Vehiculo vehiculo = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el vehiculo con el ID : " + id));
			return ResponseEntity.ok(vehiculo);
	}
	
	//este metodo sirve para actualizar vehiculo
	@PutMapping("/vehiculos/{id}")
	public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable Long id,@RequestBody Vehiculo detallesVehiculo){
		Vehiculo vehiculo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el vehiculo con el ID : " + id));
		
		vehiculo.setPlaca(detallesVehiculo.getPlaca());
		vehiculo.setMarca(detallesVehiculo.getMarca());
		vehiculo.setModelo(detallesVehiculo.getModelo());
		vehiculo.setColor(detallesVehiculo.getColor());
		vehiculo.setChasis(detallesVehiculo.getChasis());
		vehiculo.setAnio(detallesVehiculo.getAnio());
		vehiculo.setPropietario(detallesVehiculo.getPropietario());

		Vehiculo vehiculoActualizado = repositorio.save(vehiculo);
		return ResponseEntity.ok(vehiculoActualizado);
    }
	
	//este metodo sirve para eliminar un vehiculo
	@DeleteMapping("/vehiculos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarVehiculo(@PathVariable Long id){
		Vehiculo vehiculo = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el vehiculo con el ID : " + id));
		
		repositorio.delete(vehiculo);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }	

}




























