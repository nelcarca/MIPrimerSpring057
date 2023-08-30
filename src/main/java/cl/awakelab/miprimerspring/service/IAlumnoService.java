package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Alumno;
import java.util.List;

public interface IAlumnoService {
    public Alumno crearAlumno(Alumno alumnoCreado);
    public Alumno actualizarAlumno(Alumno alumno);
    public List<Alumno> listarAlumno();
    public void eliminarAlumno(Alumno alumno);
    public Alumno listaAlumnoId(int idAlumno);
}
