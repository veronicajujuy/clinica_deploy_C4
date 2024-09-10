package dh.backend.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "especialidades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;

    @ManyToMany(mappedBy = "especialidades")
    @JsonIgnoreProperties("especialidades")
    Set<Odontologo> odontologos;
}
