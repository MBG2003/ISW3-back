package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.CursoAulaHorarioDTO;
import co.edu.uniquindio.proyecto_isw3.dto.CursoDTO;
import co.edu.uniquindio.proyecto_isw3.dto.CursoGrupoDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.CursoGetDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.CursoGrupoGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.AulaCurso;
import co.edu.uniquindio.proyecto_isw3.modelo.Curso;
import co.edu.uniquindio.proyecto_isw3.modelo.CursoGrupo;
import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaCursoKey;
import co.edu.uniquindio.proyecto_isw3.modelo.key.CursoGrupoKey;
import co.edu.uniquindio.proyecto_isw3.modelo.key.CursoKey;
import co.edu.uniquindio.proyecto_isw3.repositorios.CursoGrupoRepo;
import co.edu.uniquindio.proyecto_isw3.repositorios.CursoRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.AulaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.CursoService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.ProgramaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {

    private CursoRepo cursoRepo;

    private CursoGrupoRepo cursoGrupoRepo;

    private AulaService aulaService;

    private ProgramaService programaService;

    private UsuarioService usuarioService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<CursoGetDTO> listar() throws Exception {
        List<Curso> cursos = cursoRepo.findAll();
        List<CursoGetDTO> cursosGetDTO = new ArrayList<>();

        if(cursos.isEmpty()) {
            throw new Exception(ms.getMessage("curso.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for(Curso c : cursos) {
            cursosGetDTO.add(convertir(c));
        }

        return cursosGetDTO;
    }

    @Override
    @Transactional
    public String crear(CursoDTO cursoDTO) throws Exception {
        Curso curso = convertir(cursoDTO);
        String idCurso = cursoRepo.save(curso).getKey().getIdCurso();
        for(CursoGrupoDTO g : cursoDTO.getGrupos()) {
            CursoGrupo cg = new CursoGrupo();
            CursoGrupoKey cgk = new CursoGrupoKey();
            cgk.setCurso(buscar(cursoDTO.getIdFacultad(), cursoDTO.getIdPrograma(), idCurso));
            cgk.setGrupo(g.getIdGrupo());

            cg.setKey(cgk);
            cg.setCupos(g.getCupos());
            cursoGrupoRepo.save(cg);
        }

        return idCurso;
    }

    @Override
    @Transactional
    public CursoGetDTO actualizar(CursoDTO cursoDTO) throws Exception {
        Curso curso = convertir(cursoDTO);
        validar(curso.getKey());

        Curso cursoSave = cursoRepo.save(curso);

        for(CursoGrupoDTO g : cursoDTO.getGrupos()) {
            CursoGrupo cg = new CursoGrupo();
            CursoGrupoKey cgk = new CursoGrupoKey();
            cgk.setCurso(buscar(cursoDTO.getIdFacultad(), cursoDTO.getIdPrograma(), cursoDTO.getIdCurso()));
            cgk.setGrupo(g.getIdGrupo());

            cg.setKey(cgk);
            cg.setCupos(g.getCupos());
            cursoGrupoRepo.save(cg);
        }
        return convertir(cursoSave);
    }

    @Override
    @Transactional
    public String eliminar(String idFacultad, String idPrograma, String idCurso) throws Exception {
        CursoKey key = new CursoKey();
        key.setPrograma(programaService.buscar(idFacultad, idPrograma));
        key.setIdCurso(idCurso);
        validar(key);
        cursoRepo.deleteById(key);
        return idCurso;
    }

    @Override
    @Transactional(readOnly = true)
    public Curso buscar(String idFacultad, String idPrograma, String idCurso) throws Exception {
        CursoKey key = new CursoKey();
        key.setIdCurso(idCurso);
        key.setPrograma(programaService.buscar(idFacultad, idPrograma));
        validar(key);
        return cursoRepo.findById(key).get();
    }


    private Curso convertir(CursoDTO cursoDTO) throws Exception {
        Curso curso = new Curso();
        CursoKey key = new CursoKey();

        List<AulaCurso> horario = new ArrayList<>();


        /*for (CursoAulaHorarioDTO cahd: cursoDTO.getAulas()) {
            AulaCurso ac = new AulaCurso();
            AulaCursoKey ackey = new AulaCursoKey();

            ackey.setAula(aulaService.buscar(cahd.getIdFacultad(), cahd.getIdAula()));
            ackey.setCurso(buscar(cahd.getIdFacultad(), cursoDTO.getIdPrograma(), cursoDTO.getIdCurso()));
            ac.setKey(ackey);
            ac.setDia(cahd.getDia());
            ac.setHoraInicio(LocalTime.of(cahd.getHoraInicio(), 0));
            ac.setHoraFin(LocalTime.of(cahd.getHoraFin(), 0));

            horario.add(ac);
        }*/

        key.setPrograma(programaService.buscar(cursoDTO.getIdFacultad(), cursoDTO.getIdPrograma()));
        key.setIdCurso(cursoDTO.getIdCurso());

        curso.setKey(key);
        curso.setNombre(cursoDTO.getNombre());
        curso.setPensum(cursoDTO.getPensum());
        curso.setCreditos(cursoDTO.getCreditos());
        curso.setHoras(cursoDTO.getHoras());
        curso.setNivel(cursoDTO.getNivel());
        curso.setRecursos(cursoDTO.getRecursos());
        curso.setDocente(usuarioService.buscar(cursoDTO.getIdDocente()));

        curso.setHorario(horario);

        return curso;
    }

    private CursoGetDTO convertir(Curso curso) {

        List<CursoGrupoGetDTO> grupos = new ArrayList<>();

        if(curso.getGrupos() != null) {
            for (CursoGrupo cg : curso.getGrupos()) {
                grupos.add(new CursoGrupoGetDTO(cg.getKey().getGrupo().getCodigo(), cg.getCupos()));
            }
        }

        return new CursoGetDTO(
                curso.getKey().getPrograma().getKey().getFacultad().getIdFacultad(),
                curso.getKey().getPrograma().getKey().getIdPrograma(),
                curso.getKey().getIdCurso(),
                curso.getDocente().getDocumento(),
                curso.getNombre(),
                curso.getPensum(),
                curso.getCreditos(),
                curso.getNivel(),
                curso.getHoras(),
                grupos,
                curso.getRecursos()
        );
    }

    private void validar(CursoKey key) throws Exception {
        if(!cursoRepo.existsById(key)) {
            throw new Exception(ms.getMessage("curso.no.encontrado", new Object[]{key.getIdCurso()}, LocaleContextHolder.getLocale()));
        }
    }
}
