package Microservicios.example.estudianteservice.controllers;
import Microservicios.example.estudianteservice.entities.EstudianteEntity;
import Microservicios.example.estudianteservice.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping
    public void guardarEstudiante(@RequestBody EstudianteEntity estudiante){
        estudianteService.guardarEstudiante(estudiante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteEntity> obtenerEstudiantePorId(@PathVariable("id") Long id){
        EstudianteEntity estudiante = estudianteService.findEstudianteById(id);
        return ResponseEntity.ok(estudiante);
    }
}