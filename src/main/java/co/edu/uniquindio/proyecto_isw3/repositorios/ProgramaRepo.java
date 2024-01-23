package co.edu.uniquindio.proyecto_isw3.repositorios;

import co.edu.uniquindio.proyecto_isw3.modelo.Programa;
import co.edu.uniquindio.proyecto_isw3.modelo.key.ProgramaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaRepo extends JpaRepository<Programa, ProgramaKey> {

    @Query("SELECT p FROM Programa p WHERE p.key.facultad.idFacultad = :idFacultad")
    List<Programa> listarPorFacultad(String idFacultad);
}
