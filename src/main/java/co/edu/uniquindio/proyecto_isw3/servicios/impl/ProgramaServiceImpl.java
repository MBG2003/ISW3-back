package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.get.ProgramaGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Programa;
import co.edu.uniquindio.proyecto_isw3.modelo.key.ProgramaKey;
import co.edu.uniquindio.proyecto_isw3.repositorios.ProgramaRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.FacultadService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.ProgramaService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProgramaServiceImpl implements ProgramaService {

    private ProgramaRepo programaRepo;

    private FacultadService facultadService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<ProgramaGetDTO> listar() throws Exception {
        List<Programa> programas = programaRepo.findAll();
        List<ProgramaGetDTO> programasGetDTO = new ArrayList<>();

        if(programas.isEmpty()) {
            throw new Exception(ms.getMessage("programa.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (Programa prog : programas) {
            programasGetDTO.add(convertir(prog));
        }

        return programasGetDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgramaGetDTO> listarPorFacultad(String idFacultad) throws Exception {
        List<Programa> programas = programaRepo.listarPorFacultad(idFacultad);
        List<ProgramaGetDTO> programasGetDTO = new ArrayList<>();

        if(programas.isEmpty()) {
            throw new Exception(ms.getMessage("programa.facultad.lista.vacio", new Object[]{idFacultad}, LocaleContextHolder.getLocale()));
        }

        for (Programa prog : programas) {
            programasGetDTO.add(convertir(prog));
        }

        return programasGetDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Programa buscar(String idFacultad, String idPrograma) throws Exception {
        ProgramaKey key = new ProgramaKey();
        key.setFacultad(facultadService.buscar(idFacultad));
        key.setIdPrograma(idPrograma);
        validar(key);
        return programaRepo.findById(key).get();
    }

    private ProgramaGetDTO convertir(Programa programa) {
        return new ProgramaGetDTO(
                programa.getKey().getFacultad().getIdFacultad(),
                programa.getKey().getIdPrograma(),
                programa.getNombre(),
                programa.getDescripcion()
        );
    }

    private void validar(ProgramaKey key) throws Exception{
        if (!programaRepo.existsById(key)) {
            throw new Exception(ms.getMessage("programa.no.encontrado", new Object[]{key.getIdPrograma()}, LocaleContextHolder.getLocale()));
        }
    }
}
