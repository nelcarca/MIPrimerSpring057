package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.repository.IAlumnoRepository;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;
    @Override
    public Alumno crearAlumno(Alumno alumnoCreado) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno = objAlumnoRepo.save(alumnoCreado);
        return nuevoAlumno;
    }

    @Override
    public  Alumno actualizarAlumno(Alumno alumno) {
        try {
            if (objAlumnoRepo.existsById(alumno.getId())){
                alumno.setId(alumno.getId());
                objAlumnoRepo.save(alumno);
            }else {
                throw new RuntimeException("UPS!!!! " + alumno.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return alumno;
    }

    @Override
    public List<Alumno> listarAlumno() {
        List<Alumno> listarAlumnos = new ArrayList<Alumno>();
        listarAlumnos = objAlumnoRepo.findAll();
        return listarAlumnos;
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        try {
            if (objAlumnoRepo.existsById(alumno.getId())){
                objAlumnoRepo.deleteById(alumno.getId());
            }else {
                throw new RuntimeException("UPS!!!! " + alumno.getId() + " no existe");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Alumno borrado exitosamente");
    }

    @Override
    public Alumno listaAlumnoId(int idAlumno) {

        return objAlumnoRepo.findById(idAlumno).orElse(null);
    }
}
