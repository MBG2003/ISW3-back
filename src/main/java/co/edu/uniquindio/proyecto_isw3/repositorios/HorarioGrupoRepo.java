package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.HorarioGrupo;
import co.edu.uniquindio.proyecto_isw3.modelo.key.HorarioGrupoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioGrupoRepo extends JpaRepository<HorarioGrupo, HorarioGrupoKey> {

    @Query("SELECT COUNT(hg) FROM HorarioGrupo hg")
    Integer cantidadHorarios();
}
