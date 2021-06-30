package ar.com.ada.api.empleadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    // --post/ruta
    @PostMapping("/categorias") //ningun web method devuelve void
    public ResponseEntity<?> crearCategoria (@RequestBody Categoria categoria){
        
        GenericResponse respuesta = new GenericResponse();
        
        service.crearCategoria(categoria);

        respuesta.isOk= true;
        respuesta.id= categoria.getCategoriaId();
        respuesta.message= "La categoria fue creada con éxito";
        
        return ResponseEntity.ok(respuesta);
    }

    //--get/categorias
    @GetMapping("/categorias") //hacer mapping
    public ResponseEntity<List<Categoria>> traerCategorias(){ //return responseentity
        return ResponseEntity.ok(service.traerCategorias()); //return entity con el valor esperado
    }
    
}
