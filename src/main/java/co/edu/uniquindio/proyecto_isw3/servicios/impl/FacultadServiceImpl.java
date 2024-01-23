package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.get.FacultadGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Facultad;
import co.edu.uniquindio.proyecto_isw3.repositorios.FacultadRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.FacultadService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FacultadServiceImpl implements FacultadService {

    private FacultadRepo facultadRepo;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<FacultadGetDTO> listar() throws Exception {
        List<Facultad> facultades = facultadRepo.findAll();
        List<FacultadGetDTO> facultadesGetDTO = new ArrayList<>();
        if (facultades.isEmpty()) {
            throw new Exception(ms.getMessage("facultad.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (Facultad f : facultades) {
            facultadesGetDTO.add(convertir(f));
        }

        return facultadesGetDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Facultad buscar(String idFacultad) throws Exception {
        validar(idFacultad);
        return facultadRepo.findById(idFacultad).get();
    }

    private FacultadGetDTO convertir(Facultad facultad) {
        return new FacultadGetDTO(
                facultad.getIdFacultad(),
                facultad.getNombre(),
                facultad.getDescripcion()
        );
    }

    private void validar(String idFacultad) throws Exception {
        if(!facultadRepo.existsById(idFacultad)) {
            throw new Exception(ms.getMessage("facultad.no.encontrada", new Object[]{idFacultad}, LocaleContextHolder.getLocale()));
        }
    }
}
