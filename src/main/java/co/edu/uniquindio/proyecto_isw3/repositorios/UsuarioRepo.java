package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
}
