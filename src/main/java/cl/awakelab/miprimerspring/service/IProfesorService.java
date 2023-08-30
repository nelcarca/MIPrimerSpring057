package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Profesor;
import java.util.List;

public interface IProfesorService {

        public Profesor crearProfesor(Profesor profesorCreador);

        public Profesor actualizarProfesor(int id);

        public List<Profesor> listarProfesor();

        public void eliminarProfesor(int id);
        public Profesor listaProfesorId(int idProfesor);
    }
