package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.CursoDTO;
import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.CursoGetDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/curso")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class CursoController {

    private CursoService cursoService;

    private MessageSource ms;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception {
        List<CursoGetDTO> cursos = cursoService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("curso.lista", null, LocaleContextHolder.getLocale()), cursos));
    }

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear(@RequestBody @Valid CursoDTO cursoDTO) throws Exception {
        String cursoId = cursoService.crear(cursoDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("curso.creado", new Object[]{cursoId}, LocaleContextHolder.getLocale()), cursoId));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizar(@RequestBody @Valid CursoDTO cursoDTO) throws Exception {
        CursoGetDTO curso = cursoService.actualizar(cursoDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("curso.actualizado", new Object[]{curso.getIdCurso()}, LocaleContextHolder.getLocale()), curso));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO> eliminar(@RequestParam String idFacultad, @RequestParam String idPrograma, @RequestParam String idCurso) throws Exception {
        String cursoId = cursoService.eliminar(idFacultad, idPrograma, idCurso);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("curso.eliminado", new Object[]{cursoId}, LocaleContextHolder.getLocale()), cursoId));
    }
}
