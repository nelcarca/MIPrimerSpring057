package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Alumno crearAlumno(Alumno crearAlumno) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno = objAlumnoRepo.save(crearAlumno);
        return nuevoAlumno;
    }

    @Override
    public Alumno actualizarAlumno(int id, Alumno alumnoActualizado) {
        Alumno alumnoEncontrado = objAlumnoRepo.findById(id).orElse(null);
        alumnoEncontrado.setNombres(alumnoActualizado.getNombres());
        alumnoEncontrado.setApellido1(alumnoActualizado.getApellido1());
        alumnoEncontrado.setApellido2(alumnoActualizado.getApellido2());
        alumnoEncontrado.setCursoAsignado(alumnoActualizado.getCursoAsignado());
        return objAlumnoRepo.save(alumnoEncontrado);
    }

    @Override
    public List<Alumno> listarAlumno() {
        List<Alumno> listarAlumnos = new ArrayList<Alumno>();
        listarAlumnos = objAlumnoRepo.findAll();
        return listarAlumnos;
    }
    @Override
    public Alumno asignarCursoAlumno(int idAlumno, int cursoId){
        Alumno alumno = objAlumnoRepo.findById(idAlumno).orElse(null);
        Curso curso = objCursoRepo.findById(cursoId).orElse(null);
        List<Curso> listarCurso = new ArrayList<>();
        listarCurso.add(curso);
        alumno.setCursoAsignado(curso);
        return objAlumnoRepo.save(alumno);
    }

    @Override
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
    }

    @Override
    public Alumno listaAlumnoId(int idAlumno) {

        return objAlumnoRepo.findById(idAlumno).orElse(null);
    }
}
