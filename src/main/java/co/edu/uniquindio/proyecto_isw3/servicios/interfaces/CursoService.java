package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.AulaCursoDTO;
import co.edu.uniquindio.proyecto_isw3.dto.CursoDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.CursoGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Curso;

import java.util.List;

public interface CursoService {

    List<CursoGetDTO> listar() throws Exception;

    String crear(CursoDTO cursoDTO) throws Exception;

    CursoGetDTO actualizar(CursoDTO cursoDTO) throws Exception;

    String eliminar(String idFacultad, String idPrograma, String idCurso) throws Exception;

    Curso buscar(String idFacultad, String idPrograma, String idCurso) throws Exception;

    void asignarAula(AulaCursoDTO aulaCursoDTO) throws Exception;
}
