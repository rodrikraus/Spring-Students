package com.example.demo.Controller;

import com.example.demo.Models.Estudiante;
import com.example.demo.Service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EstudianteRestController {
    @Autowired
    private IEstudianteService estService;

    @PostMapping("/new/estudiante")
    public String agregarEstudiante(@RequestBody Estudiante e) {
        estService.crearEstudiante(e);
        return "Estudiante creado con éxito!";
    }

    @GetMapping("/ver/estudiantes")
    @ResponseBody
    public List<Estudiante> verEstudiantes() {
        return estService.verEstudiantes();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEstudiante(@PathVariable Long id) {
        estService.borrarEstudiante(id);
    }

    @GetMapping("/ver/estudiante/{id}")
    @ResponseBody
    public Estudiante buscarEstudiante(@PathVariable Long id) {
        return estService.buscarEstudiante(id);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public void actualizarEstudiante(@PathVariable("id") long id, @RequestBody Estudiante e) {
        Estudiante est = estService.buscarEstudiante(id);
        if(!est.equals(null)) {
            est.setNombre(e.getNombre());
            est.setApellido(e.getApellido());
            est.setEmail(e.getEmail());
            estService.actualizarEstudiante(e);
        }
    }

}
