package portfolioJAVA.tareasApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolioJAVA.tareasApp.modelos.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Integer>{

}
