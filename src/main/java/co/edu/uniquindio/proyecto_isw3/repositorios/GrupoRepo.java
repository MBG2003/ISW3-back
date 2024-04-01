package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepo extends JpaRepository<Grupo, Integer> {
}
