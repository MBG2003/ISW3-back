package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.SolicitudDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.SolicitudGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.MejoraProblema;
import co.edu.uniquindio.proyecto_isw3.repositorios.MejoraProblemaRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.AulaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.MejoraProblemaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MejoraProblemaServiceImpl implements MejoraProblemaService {

    private MejoraProblemaRepo mpRepo;

    private AulaService aulaService;

    private UsuarioService usuarioService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<SolicitudGetDTO> listar() throws Exception {
        List<MejoraProblema> solicitudes = mpRepo.findAll();
        List<SolicitudGetDTO> solicitudesGetDTO = new ArrayList<>();

        if(solicitudes.isEmpty()) {
            throw new Exception(ms.getMessage("mejora.problema.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for(MejoraProblema mp : solicitudes) {
            solicitudesGetDTO.add(convertir(mp));
        }

        return solicitudesGetDTO;
    }

    @Override
    @Transactional
    public int agregar(SolicitudDTO solicitudDTO) throws Exception {
        MejoraProblema mp = convertir(solicitudDTO);
        return mpRepo.save(mp).getIdSolicitud();
    }

    @Override
    @Transactional
    public SolicitudGetDTO actualizar(SolicitudDTO solicitudDTO) throws Exception {
        validar(solicitudDTO.getIdSolicitud());
        MejoraProblema mp = convertir(solicitudDTO);
        return convertir(mpRepo.save(mp));
    }

    @Override
    @Transactional
    public int eliminar(int idSolicitud) throws Exception {
        validar(idSolicitud);
        mpRepo.deleteById(idSolicitud);
        return idSolicitud;
    }

    private SolicitudGetDTO convertir(MejoraProblema mp) {
        return new SolicitudGetDTO(
                mp.getEmisor().getDocumento(),
                mp.getAula().getKey().getFacultad().getIdFacultad(),
                mp.getAula().getKey().getIdAula(),
                mp.getIdSolicitud(),
                mp.getDescripcion(),
                mp.getObservaciones(),
                mp.getEstado()
        );
    }

    private MejoraProblema convertir(SolicitudDTO solicitudDTO) throws Exception {
        MejoraProblema mp = new MejoraProblema();

        mp.setIdSolicitud(solicitudDTO.getIdSolicitud());
        mp.setAula(aulaService.buscar(solicitudDTO.getIdFacultad(), solicitudDTO.getIdAula()));
        mp.setEmisor(usuarioService.buscar(solicitudDTO.getEmisor()));
        mp.setDescripcion(solicitudDTO.getDescripcion());
        mp.setEstado(solicitudDTO.getEstado());
        mp.setObservaciones(solicitudDTO.getObservaciones());

        return mp;
    }

    private void validar(int idSolicitud) throws Exception {
        if(!mpRepo.existsById(idSolicitud)) {
            throw new Exception(ms.getMessage("mejora.problema.no.encontrado", new Object[]{idSolicitud}, LocaleContextHolder.getLocale()));
        }
    }
}
