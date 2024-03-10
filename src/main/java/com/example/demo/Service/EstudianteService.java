package com.example.demo.Service;


import com.example.demo.Models.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    public EstudianteRepository estRepo;

    @Override
    public List<Estudiante> verEstudiantes() {
        return estRepo.findAll();
    }

    @Override
    public void crearEstudiante(Estudiante e) {
        estRepo.save(e);
    }

    @Override
    public void borrarEstudiante(Long id) {
        estRepo.deleteById(id);
    }

    @Override
    public Estudiante buscarEstudiante(Long id) {
        return estRepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarEstudiante(Estudiante e) {
        estRepo.save(e);
    }
}
