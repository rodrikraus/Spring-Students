package com.example.demo.Service;

import com.example.demo.Models.Estudiante;

import java.util.List;

public interface IEstudianteService {
    public List<Estudiante> verEstudiantes();
    public void crearEstudiante(Estudiante e);
    public void borrarEstudiante(Long id);
    public Estudiante buscarEstudiante(Long id);
    public void actualizarEstudiante(Estudiante e);
}
