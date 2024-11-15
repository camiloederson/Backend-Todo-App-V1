package portfolioJAVA.tareasApp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolioJAVA.tareasApp.modelos.Tareas;
import portfolioJAVA.tareasApp.modelos.Usuario;
import portfolioJAVA.tareasApp.repositorios.TareaRepositorio;
import portfolioJAVA.tareasApp.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private TareaRepositorio tareaRepositorio;

    public List<Usuario> getAllUsers(){
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios en la base de datos.");
        } else {
            System.out.println("Se encontraron " + usuarios.size() + " usuarios.");
        }
        return usuarios;
    }

    public Optional<Usuario> getUserById(Integer id){
        return usuarioRepositorio.findById(id);
    }

    public void saveUser(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public void removeUser(Integer id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if(usuario.isPresent()){
            List<Tareas> tareasRelacionadas = tareaRepositorio.findByUsuarioId(id);
            if(!tareasRelacionadas.isEmpty()){
                throw new IllegalStateException("No se puede eliminar el usuario porque tiene tareas asociadas.");
            }
            else {
                usuarioRepositorio.deleteById(id);
            }
        }
        else{
            throw new IllegalStateException("No se encontro el usuario");
        }
    }
}
