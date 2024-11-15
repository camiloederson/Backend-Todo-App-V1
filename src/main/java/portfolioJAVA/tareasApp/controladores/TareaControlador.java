package portfolioJAVA.tareasApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolioJAVA.tareasApp.modelos.Tareas;
import portfolioJAVA.tareasApp.repositorios.TareaRepositorio;
import portfolioJAVA.tareasApp.servicios.TareaServicio;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping ("/api/tareas")
public class TareaControlador {
    @Autowired
    private TareaServicio tareaServicio;

    @GetMapping
    public List<Tareas> getAllTareas(){
        return tareaServicio.getAllTareas();
    }

    @GetMapping ("/{id}")
    public Tareas getTareasById(@PathVariable Integer id){
                   return tareaServicio.getTareaById(id).orElse(null);
    }

    @PostMapping
    public void saveTarea(Tareas tarea){
        tareaServicio.saveTarea(tarea);
    }

    @DeleteMapping ("/{id}")
    public void removeTarea(@PathVariable Integer id){
        tareaServicio.removeTarea(id);
    }
}
