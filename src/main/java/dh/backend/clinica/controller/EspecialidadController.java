package dh.backend.clinica.controller;

import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.dto.response.EspecialidadResponseDto;
import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.service.IEspecialidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    private IEspecialidadService especialidadService;

    public EspecialidadController(IEspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<EspecialidadResponseDto> guardarEspecialidad(@RequestBody EspecialidadRequestDto especialidad){
        return ResponseEntity.ok(especialidadService.guardarEspecialidad(especialidad));
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<EspecialidadResponseDto>> buscarTodasEspecialidades(){
        return ResponseEntity.ok(especialidadService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EspecialidadResponseDto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(especialidadService.buscarPorId(id).get());
    }
}
