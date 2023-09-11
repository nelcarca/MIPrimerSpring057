package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import java.util.List;

public interface IProfesorService {

        Profesor crearProfesor(Profesor profesorCreador);


        Profesor actualizarProfesor(int id, Profesor profesorActualizado);

        List<Profesor> listarProfesor();
        Profesor asignarCursoAProfesor(Profesor profesor, Curso curso);


        void eliminarProfesor(int id);
        Profesor listaProfesorId(int idProfesor);
    }
