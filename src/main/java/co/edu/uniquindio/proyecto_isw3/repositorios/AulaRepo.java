package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.Aula;
import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepo extends JpaRepository<Aula, AulaKey> {

    @Query("SELECT a FROM Aula a WHERE a.key.facultad.idFacultad = :idFacultad")
    List<Aula> listarPorFacultad(String idFacultad);
}
