package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.AulaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.AulaGetDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.RecursoGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Aula;
import co.edu.uniquindio.proyecto_isw3.modelo.RecursoAV;
import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaKey;
import co.edu.uniquindio.proyecto_isw3.repositorios.AulaRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.AulaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.FacultadService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AulaServiceImpl implements AulaService {

    private AulaRepo aulaRepo;

    private FacultadService facultadService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<AulaGetDTO> listar() throws Exception {
        List<Aula> aulas = aulaRepo.findAll();
        List<AulaGetDTO> aulasGetDTO = new ArrayList<>();
        if(aulas.isEmpty()) {
            throw new Exception(ms.getMessage("aula.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (Aula a : aulas) {
            aulasGetDTO.add(convertir(a));
        }
        return aulasGetDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AulaGetDTO> listarPorFacultad(String idFacultad) throws Exception {
        List<Aula> aulas = aulaRepo.listarPorFacultad(idFacultad);
        List<AulaGetDTO> aulasGetDTO = new ArrayList<>();
        if(aulas.isEmpty()) {
            throw new Exception(ms.getMessage("aula.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (Aula a : aulas) {
            aulasGetDTO.add(convertir(a));
        }
        return aulasGetDTO;
    }

    @Override
    @Transactional
    public String crear(AulaDTO aulaDTO) throws Exception {
        Aula aula = convertir(aulaDTO);
        if(aulaRepo.existsById(aula.getKey())){
            throw new Exception(ms.getMessage("aula.ya.existe", new Object[]{aula.getKey().getIdAula(), aula.getKey().getFacultad().getIdFacultad()}, LocaleContextHolder.getLocale()));
        }
        return aulaRepo.save(aula).getKey().getIdAula();
    }

    @Override
    @Transactional
    public AulaGetDTO actualizar(AulaDTO aulaDTO) throws Exception {
        Aula aula = convertir(aulaDTO);
        validar(aula.getKey());
        return convertir(aulaRepo.save(aula));
    }

    @Override
    @Transactional
    public String eliminar(String idFacultad, String idAula) throws Exception {
        AulaKey key = new AulaKey();
        key.setFacultad(facultadService.buscar(idFacultad));
        key.setIdAula(idAula);
        validar(key);
        aulaRepo.deleteById(key);
        return idAula;
    }

    @Override
    @Transactional(readOnly = true)
    public Aula buscar(String idFacultad, String idAula) throws Exception {
        AulaKey key = new AulaKey();
        key.setIdAula(idAula);
        key.setFacultad(facultadService.buscar(idFacultad));
        validar(key);
        return aulaRepo.findById(key).get();
    }

    private Aula convertir(AulaDTO aulaDTO) throws Exception {
        AulaKey key = new AulaKey();
        key.setFacultad(facultadService.buscar(aulaDTO.getIdFacultad()));
        key.setIdAula(aulaDTO.getIdAula());
        Aula aula = new Aula();
        aula.setKey(key);
        aula.setNombre(aulaDTO.getNombre());
        aula.setCapacidad(aulaDTO.getCapacidad());
        aula.setEstado(aulaDTO.getEstado());
        aula.setRecursosAV(aulaDTO.getRecursos());

        return aula;
    }

    private AulaGetDTO convertir(Aula aula) {
        return new AulaGetDTO(
                aula.getKey().getFacultad().getIdFacultad(),
                aula.getKey().getIdAula(),
                aula.getNombre(),
                aula.getCapacidad(),
                aula.getEstado(),
                aula.getRecursosAV()
        );
    }

    private void validar(AulaKey key) throws Exception {
        if(!aulaRepo.existsById(key)) {
            throw new Exception(ms.getMessage("aula.no.encontrada", new Object[]{key.getIdAula()}, LocaleContextHolder.getLocale()));
        }
    }
}
