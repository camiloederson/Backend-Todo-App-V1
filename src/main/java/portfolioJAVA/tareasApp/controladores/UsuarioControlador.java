package portfolioJAVA.tareasApp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import portfolioJAVA.tareasApp.modelos.Usuario;
import portfolioJAVA.tareasApp.servicios.UsuarioServicio;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping ("/api/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> getUsers(){
        return usuarioServicio.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Integer id){
        return usuarioServicio.getUserById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody Usuario usuario){
        try{
            usuarioServicio.saveUser(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Integer id) {
        try {
            usuarioServicio.removeUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage()); // Error general
        }
    }
}
