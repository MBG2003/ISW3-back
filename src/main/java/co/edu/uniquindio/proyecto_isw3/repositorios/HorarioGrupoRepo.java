package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.HorarioGrupo;
import co.edu.uniquindio.proyecto_isw3.modelo.key.HorarioGrupoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioGrupoRepo extends JpaRepository<HorarioGrupo, HorarioGrupoKey> {

    @Query("SELECT COUNT(hg) FROM HorarioGrupo hg WHERE hg.key.grupo.key.curso.key.idCurso = :idCurso AND hg.key.grupo.key.grupo.idGrupo = :idGrupo")
    Integer cantidadHorariosCursoGrupo(String idCurso, int idGrupo);

    @Modifying
    @Query("DELETE FROM HorarioGrupo hg WHERE hg.key.grupo.key.curso.key.idCurso = :idCurso AND hg.key.grupo.key.grupo.idGrupo = :idGrupo")
    void eliminarHorariosCursoGrupo(String idCurso, int idGrupo);
}
