package Microservicios.example.notasservice.controllers;
import Microservicios.example.notasservice.entities.NotasEntity;
import Microservicios.example.notasservice.models.ResumenModel;
import Microservicios.example.notasservice.services.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/examenes")
public class NotasController {

    @Autowired
    private NotasService notasService;

    @GetMapping
    public ResponseEntity<List<NotasEntity>> listar() {
        ArrayList<NotasEntity> examenEntities = notasService.obtenerData();
        return ResponseEntity.ok(examenEntities);
    }

    @GetMapping("/puntaje-promedio/{rut}")
    public ResponseEntity<Double> obtenerPuntajePromedio(@PathVariable String rut){
        Double puntaje = notasService.calcularPuntajePromedio(rut);
        return ResponseEntity.ok(puntaje);
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("archivo") MultipartFile archivo, RedirectAttributes redirectAttributes) {
        notasService.guardar(archivo);
        redirectAttributes.addFlashAttribute("mensaje", "Archivo cargado correctamente");
        notasService.leerCsv("Examenes.csv");
    }

    @GetMapping("/resumen/{idEstudiante}")
    public ResponseEntity<ResumenModel> obtenerResumenEstudiante(@PathVariable Long idEstudiante) {
        ResumenModel resumen = notasService.obtenerResumen(idEstudiante);
        return ResponseEntity.ok(resumen);
    }

}