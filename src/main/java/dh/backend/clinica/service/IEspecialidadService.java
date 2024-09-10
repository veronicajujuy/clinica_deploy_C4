package dh.backend.clinica.service;

import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.dto.response.EspecialidadResponseDto;
import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    EspecialidadResponseDto guardarEspecialidad(EspecialidadRequestDto especialidadRequestDto);

    Optional<EspecialidadResponseDto> buscarPorId(Integer id);
    List<EspecialidadResponseDto> buscarTodos();

    void modificarEspecialidad(EspecialidadRequestDto especialidad);

    void eliminarEspecialidad(Integer id);
}
