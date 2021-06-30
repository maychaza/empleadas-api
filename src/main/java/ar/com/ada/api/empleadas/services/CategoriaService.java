package ar.com.ada.api.empleadas.services;

import java.util.List;
import java.util.Optional;

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

    public Categoria buscarCategoria(Integer categoriaId){
        
        Optional<Categoria> resultado = repository.findById(categoriaId);
        Categoria categoria= null; //nulo predefinidamente

        if (resultado.isPresent()) //pregunta si tiene la info
        categoria = resultado.get(); // si la tiene, la guarda en la variable
        return categoria;

    }
    
}
