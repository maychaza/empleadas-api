package ar.com.ada.api.empleadas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.repos.*;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public void crearCategoria(Categoria categoria){
        repository.save(categoria);
    }

    public List<Categoria> traerCategorias(){
        return repository.findAll();
    }
    
}
