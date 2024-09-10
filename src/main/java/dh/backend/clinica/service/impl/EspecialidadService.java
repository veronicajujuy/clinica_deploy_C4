package dh.backend.clinica.service.impl;

import dh.backend.clinica.dto.request.EspecialidadRequestDto;
import dh.backend.clinica.dto.response.EspecialidadResponseDto;
import dh.backend.clinica.entity.Especialidad;
import dh.backend.clinica.exception.ResourceNotFoundException;
import dh.backend.clinica.repository.IEspecialidadRepository;
import dh.backend.clinica.service.IEspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService implements IEspecialidadService {

    private IEspecialidadRepository especialidadRepository;
    @Autowired
    private ModelMapper modelMapper;

    public EspecialidadService(IEspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public EspecialidadResponseDto guardarEspecialidad(EspecialidadRequestDto especialidadRequestDto) {
        Especialidad especialidad = convertirAEspecialidad(especialidadRequestDto);
        Especialidad especialidadDesdeBd = especialidadRepository.save(especialidad);
        EspecialidadResponseDto especialidadARetornar = convertirAResponse(especialidadDesdeBd);
        return especialidadARetornar;
    }

    @Override
    public Optional<EspecialidadResponseDto> buscarPorId(Integer id) {
        Optional<Especialidad> especialidadEncontrada = especialidadRepository.findById(id);
        if(especialidadEncontrada.isPresent()){
            EspecialidadResponseDto especialidadARetornar = convertirAResponse(especialidadEncontrada.get());
            return Optional.ofNullable(especialidadARetornar);
        } else {
            throw  new ResourceNotFoundException("La especialidad no fue encontrada");
        }
    }

    @Override
    public List<EspecialidadResponseDto> buscarTodos() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        List<EspecialidadResponseDto> especialidadesARetornar = new ArrayList<>();
        for(Especialidad e: especialidades){
            especialidadesARetornar.add(convertirAResponse(e));
        }
        return especialidadesARetornar;
    }

    @Override
    public void modificarEspecialidad(EspecialidadRequestDto especialidadRequestDto) {

    }

    @Override
    public void eliminarEspecialidad(Integer id) {

    }

    private EspecialidadResponseDto convertirAResponse(Especialidad especialidad){
        modelMapper.typeMap(Especialidad.class, EspecialidadResponseDto.class).addMappings(
                mapper -> mapper.map(src -> src.getOdontologos(), EspecialidadResponseDto::setOdontologo)
        );
        return modelMapper.map(especialidad, EspecialidadResponseDto.class);

    }

    private Especialidad convertirAEspecialidad(EspecialidadRequestDto especialidad){
        return modelMapper.map(especialidad, Especialidad.class);
    }
}
