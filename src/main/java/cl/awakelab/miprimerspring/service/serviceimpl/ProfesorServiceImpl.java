package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    IProfesorRepository objProfesorRepo;
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Profesor crearProfesor(Profesor crearProfesor) {
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor = objProfesorRepo.save(crearProfesor);
        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(int id, Profesor profesorActualizado) {
        Profesor profesorEncontrado = objProfesorRepo.findById(id).orElse(null);
        profesorEncontrado.setNombres(profesorActualizado.getNombres());
        profesorEncontrado.setApellido1(profesorActualizado.getApellido1());
        profesorEncontrado.setApellido2(profesorActualizado.getApellido2());
        return objProfesorRepo.save(profesorEncontrado);
    }

    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaMuestra = new ArrayList<>();
        listaMuestra = objProfesorRepo.findAll();
        return listaMuestra;
    }
    @Override
    public Profesor asignarCursoAProfesor(int id, int cursoId){
        Profesor profesor = objProfesorRepo.findById(id).orElse(null);
        Curso curso = objCursoRepo.findById(cursoId).orElse(null);
        List<Curso> listarCurso = new ArrayList<>();
        listarCurso.add(curso);
        profesor.setListaCursos(listarCurso);
        return objProfesorRepo.save(profesor);
    }

    @Override
    public void eliminarProfesor(int id) {
    objProfesorRepo.deleteById(id);
    }

    @Override
    public Profesor listaProfesorId(int idProfesor) {

        return objProfesorRepo.findById(idProfesor).orElse(null);
    }
}
