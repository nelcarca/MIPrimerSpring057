package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.dto.AlumnoDto;
import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service ("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Autowired
    ICursoRepository objCursoRepo;

    @Override
    public Alumno crearAlumno(Alumno crearAlumno) {
        Alumno nuevoAlumno = new Alumno();
        Curso cursoAsignado = new Curso();
        cursoAsignado = objCursoRepo.findById(crearAlumno.getCursoAsignado().getId()).orElse(null);
        crearAlumno.setCursoAsignado(cursoAsignado);
        nuevoAlumno = objAlumnoRepo.save(crearAlumno);
        return nuevoAlumno;
    }
    @Override
    public List<AlumnoDto> obtenerAlumnosDto() {
        List<Alumno> obtenerListaDeAlumnos = null;
        List<Alumno> alumnos = obtenerListaDeAlumnos; // Obtiene la lista de alumnos desde tu repositorio

        // Convierte los alumnos a DTOs
        List<AlumnoDto> alumnosDTO = alumnos.stream()
                .map(alumno -> {
                    AlumnoDto alumnodto = new AlumnoDto();
                    alumnodto.setId(alumno.getId());
                    alumnodto.setNombres(alumno.getNombres());
                    alumnodto.setApellido1(alumno.getApellido1());
                    alumnodto.setApellido2(alumno.getApellido2());
                    alumnodto.setNombreCurso(alumno.getCursoAsignado().getNombreCurso()); // Obtiene el nombre del curso
                    return alumnodto;
                })
                .collect(Collectors.toList());

        return alumnosDTO;
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
    public void eliminarAlumno(int id) {
        objAlumnoRepo.deleteById(id);
    }

    @Override
    public Alumno listaAlumnoId(int idAlumno) {

        return objAlumnoRepo.findById(idAlumno).orElse(null);
    }
}
