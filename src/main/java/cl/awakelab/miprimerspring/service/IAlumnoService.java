package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Alumno;
import java.util.List;

public interface IAlumnoService {
    public Alumno crearAlumno(Alumno crearAlumno);
    Alumno actualizarAlumno(int id, Alumno alumnoActualizado);

    public List<Alumno> listarAlumno();

    void eliminarAlumno(int id);

    public Alumno listaAlumnoId(int idAlumno);
}
