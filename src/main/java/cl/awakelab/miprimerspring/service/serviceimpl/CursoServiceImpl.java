package cl.awakelab.miprimerspring.service.serviceimpl;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {
    @Autowired
    ICursoRepository objCursoRepo;
    IProfesorRepository objProfesorRepo;

    @Override
    public Curso crearCurso(Curso cursoCreador) {

        return objCursoRepo.save(cursoCreador);
    }

    @Override
    public Curso actualizarCurso(int id, Curso curso) {
        Curso cursoEncontrado = objCursoRepo.findById(id).orElse(null);
        cursoEncontrado.setNombreCurso(curso.getNombreCurso());
        return objCursoRepo.save(cursoEncontrado);
    }

    @Override
    public List<Curso> listarCurso() {
        List<Curso> listarCurso = new ArrayList<>();
        listarCurso = objCursoRepo.findAll();
        return listarCurso;
    }
    @Override
    public Curso asignarProfesorACurso(Curso cursoRecibido, Profesor profesorRecibido){
        Curso curso = objCursoRepo.findById(cursoRecibido.getId()).orElse(null);
        Profesor profesor = objProfesorRepo.findById(profesorRecibido.getId()).orElse(null);
        List<Profesor> listaProfesorAsignar = new ArrayList<>();
        listaProfesorAsignar.add(profesor);
        curso.setListaProfesores(listaProfesorAsignar);
        return objCursoRepo.save(curso);
    }

    @Override
    public void eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
    }

    @Override
    public Curso listaCursoId(int idCurso) {
        return objCursoRepo.findById(idCurso).orElse(null);
    }
}
