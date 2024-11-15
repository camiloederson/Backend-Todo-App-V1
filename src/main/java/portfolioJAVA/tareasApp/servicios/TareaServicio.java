package portfolioJAVA.tareasApp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolioJAVA.tareasApp.modelos.Tareas;
import portfolioJAVA.tareasApp.repositorios.TareaRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServicio {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    public List<Tareas> getAllTareas (){
        return tareaRepositorio.findAll();
    }

    public Optional<Tareas> getTareaById(Integer id){
        return tareaRepositorio.findById(id);
    }

    public void saveTarea(Tareas tarea){
        tareaRepositorio.save(tarea);
    }

    public void removeTarea(Integer id){
        tareaRepositorio.deleteById(id);
    }
}
