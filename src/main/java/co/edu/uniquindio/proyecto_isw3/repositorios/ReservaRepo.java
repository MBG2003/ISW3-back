package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.ReservaAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepo extends JpaRepository<ReservaAula, Integer> {

    @Query("SELECT r FROM ReservaAula r WHERE r.aula.key.facultad.idFacultad = :idFacultad AND r.aula.key.idAula = :idAula")
    List<ReservaAula> listarPorAula(String idFacultad, String idAula);
}
