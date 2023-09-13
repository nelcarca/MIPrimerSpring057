package cl.awakelab.miprimerspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(nullable = false, length = 72)
    private String nombres;

    @Column(length = 30)
    private String apellido1;

    @Column(length = 30)
    private String apellido2;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_Curso", nullable = false)
    private Curso cursoAsignado;

    @ManyToMany
    @JoinTable(name = "Curso_Profesor",
    inverseJoinColumns = @JoinColumn(name = "FK_Curso", nullable = false))
    private List<Curso> listaCursos;

}
