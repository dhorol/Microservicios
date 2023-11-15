package Microservicios.example.estudianteservice.controllers;
import Microservicios.example.estudianteservice.entities.EstudianteEntity;
import Microservicios.example.estudianteservice.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.http.ResponseEntity;


@RestController

@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService estudianteService;


    @GetMapping("/listado")
    public ResponseEntity<List<EstudianteEntity>> obtenerEstudiantes(){
        List<EstudianteEntity> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if(estudiantes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping("/")
    public ResponseEntity<?> guardarEstudiante(@RequestBody EstudianteEntity estudiante) {
        try {
            estudianteService.guardarEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante guardado con éxito");
        } catch (Exception e) {
            // Manejo de la excepción, por ejemplo, si falla la inserción en la base de datos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el estudiante");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteEntity> obtenerEstudiantePorId(@PathVariable("id") Long id){
        EstudianteEntity estudiante = estudianteService.findEstudianteById(id);
        return ResponseEntity.ok(estudiante);
    }
}