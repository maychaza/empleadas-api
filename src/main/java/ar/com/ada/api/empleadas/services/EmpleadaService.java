package ar.com.ada.api.empleadas.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.entities.Empleada;
import ar.com.ada.api.empleadas.entities.Empleada.EstadoEmpleadaEnum;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.repos.EmpleadaRepository;

@Service
public class EmpleadaService {

    //declarar el atributo repo
    @Autowired
    EmpleadaRepository repo;

    @Autowired
    CategoriaService categoriaService;

    public void crearEmpleada(Empleada empleada){
        repo.save(empleada);
    }

    public List<Empleada> traerEmpleadas(){
        return repo.findAll();
    }

    public Empleada buscarEmpleada(Integer EmpleadaId){
        Optional<Empleada> resultado = repo.findById(EmpleadaId);

        if(resultado.isPresent())
             return resultado.get();
        return null;     
    }

// Delete logico, cambia solo estatus pero sigue en la db
    public void bajaEmpleadaPorId(Integer id) {
        Empleada empleada = this.buscarEmpleada(id);

        empleada.setEstado(EstadoEmpleadaEnum.BAJA);
        empleada.setFechaBaja(new Date());

        repo.save(empleada);
    }

    public List<Empleada> traerEmpleadaPorCategoria(Integer catId) {
        
        Categoria categoria = categoriaService.buscarCategoria(catId);
        
        return categoria.getEmpleadas();
    }

    public void guardar(Empleada empleada) {
        repo.save(empleada);
    }

    
    
}
