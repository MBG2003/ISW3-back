package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.AulaCurso;
import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaCursoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaCursoRepo extends JpaRepository<AulaCurso, AulaCursoKey> {
}
