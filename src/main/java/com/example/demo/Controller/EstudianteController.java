package com.example.demo.Controller;

import com.example.demo.Models.Estudiante;
import com.example.demo.Service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteService serviceEstudiantes;

    @GetMapping
    public String verEstudiantes(Model model) {
        List<Estudiante> listaEstudiantes = serviceEstudiantes.verEstudiantes();
        model.addAttribute("estudiantes", listaEstudiantes);
        return "listado";
    }

    @GetMapping("/agregarEstudiante")
    public String agregarEstudianteForm(Model model) {
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "agregarEstudiante";
    }

    @PostMapping("/guardarEstudianteNuevo")
    public String agregarEstudiante(@ModelAttribute Estudiante nuevoEstudiante) {
        serviceEstudiantes.crearEstudiante(nuevoEstudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/modificarEstudiante/{id}")
    public String modificarEstudiante(@PathVariable long id, Model model) {
        Estudiante estudiante = serviceEstudiantes.buscarEstudiante(id);
        model.addAttribute("estudiante", estudiante);
        return "modificarEstudiante";
    }

    @PostMapping("guardarModificacionEstudiante")
    public String guardarModificacionEstudiante(@ModelAttribute Estudiante estudiante) {
        serviceEstudiantes.crearEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/borrar/{id}")
    public String borrarEstudiante(@PathVariable long id) {
        serviceEstudiantes.borrarEstudiante(id);
        return "redirect:/estudiantes";
    }



}
