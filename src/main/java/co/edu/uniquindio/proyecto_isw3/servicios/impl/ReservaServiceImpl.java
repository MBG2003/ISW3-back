package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.ReservaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ReservaGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.ReservaAula;
import co.edu.uniquindio.proyecto_isw3.repositorios.ReservaRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.AulaService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.ReservaService;
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
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepo reservaRepo;

    private AulaService aulaService;

    private UsuarioService usuarioService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public List<ReservaGetDTO> listar() throws Exception {
        List<ReservaAula> reservas = reservaRepo.findAll();
        List<ReservaGetDTO> reservasGetDTO = new ArrayList<>();

        if(reservas.isEmpty()) {
            throw new Exception(ms.getMessage("reserva.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (ReservaAula r : reservas) {
            reservasGetDTO.add(convertir(r));
        }

        return reservasGetDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaGetDTO> listarPorAula(String idFacultad, String idAula) throws Exception {
        List<ReservaAula> reservas = reservaRepo.listarPorAula(idFacultad, idAula);
        List<ReservaGetDTO> reservasGetDTO = new ArrayList<>();

        if(reservas.isEmpty()) {
            throw new Exception(ms.getMessage("reserva.lista.vacio", null, LocaleContextHolder.getLocale()));
        }

        for (ReservaAula r : reservas) {
            reservasGetDTO.add(convertir(r));
        }

        return reservasGetDTO;
    }

    @Override
    @Transactional
    public int agregar(ReservaDTO reservaDTO) throws Exception {
        ReservaAula reserva = convertir(reservaDTO);
        return reservaRepo.save(reserva).getIdReserva();
    }

    @Override
    @Transactional
    public ReservaGetDTO actualizar(ReservaDTO reservaDTO) throws Exception {
        validar(reservaDTO.getIdReserva());
        ReservaAula reserva = convertir(reservaDTO);
        return convertir(reservaRepo.save(reserva));
    }

    @Override
    @Transactional
    public int eliminar(int idReserva) throws Exception {
        validar(idReserva);
        reservaRepo.deleteById(idReserva);
        return idReserva;
    }

    private ReservaGetDTO convertir(ReservaAula reserva) {
        return new ReservaGetDTO(
                reserva.getIdReserva(),
                reserva.getAula().getKey().getFacultad().getIdFacultad(),
                reserva.getAula().getKey().getIdAula(),
                reserva.getEmisor().getDocumento(),
                reserva.getAsunto(),
                reserva.getDescripcion(),
                reserva.getEstado(),
                reserva.getFecha(),
                reserva.getHoraInicio(),
                reserva.getHoraFin(),
                reserva.getObservaciones()
        );
    }

    private ReservaAula convertir(ReservaDTO reservaDTO) throws Exception {
        ReservaAula reserva = new ReservaAula();

        reserva.setIdReserva(reservaDTO.getIdReserva());
        reserva.setAula(aulaService.buscar(reservaDTO.getIdFacultad(), reservaDTO.getIdAula()));
        reserva.setEmisor(usuarioService.buscar(reservaDTO.getEmisor()));
        reserva.setAsunto(reservaDTO.getAsunto());
        reserva.setDescripcion(reservaDTO.getDescripcion());
        reserva.setEstado(reservaDTO.getEstado());
        reserva.setFecha(reservaDTO.getFecha());
        reserva.setHoraInicio(reservaDTO.getHoraInicio());
        reserva.setHoraFin(reservaDTO.getHoraFin());
        reserva.setObservaciones(reservaDTO.getObservaciones());

        return reserva;
    }

    private void validar(int idReserva) throws Exception {
        if(!reservaRepo.existsById(idReserva)) {
            throw new Exception(ms.getMessage("reserva.no.encontrado", new Object[]{idReserva}, LocaleContextHolder.getLocale()));
        }
    }
}
