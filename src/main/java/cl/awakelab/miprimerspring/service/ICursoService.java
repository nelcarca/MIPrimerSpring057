package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;

import java.util.List;

public interface ICursoService {
    Curso crearCurso(Curso cursoCreador);


    Curso actualizarCurso(int id, Curso cursoActualizado);

    List<Curso> listarCurso();
    Curso asignarProfesorACurso(Curso curso, Profesor profesor);

    void eliminarCurso(int id);
    Curso listaCursoId(int idCurso);
}
