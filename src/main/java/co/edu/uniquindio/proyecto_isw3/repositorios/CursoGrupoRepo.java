package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.CursoGrupo;
import co.edu.uniquindio.proyecto_isw3.modelo.key.CursoGrupoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoGrupoRepo extends JpaRepository<CursoGrupo, CursoGrupoKey> {
}
