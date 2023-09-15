package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Alumno;
import java.util.List;

public interface IAlumnoService {
    Alumno crearAlumno(Alumno crearAlumno);
    Alumno actualizarAlumno(int id, Alumno alumnoActualizado);

    List<Alumno> listarAlumno();
    Alumno asignarCursoAlumno(int idAlumno, int cursoId);

    void eliminarAlumno(int id);

    Alumno listaAlumnoId(int idAlumno);
}
