package dh.backend.clinica.repository;

import dh.backend.clinica.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
