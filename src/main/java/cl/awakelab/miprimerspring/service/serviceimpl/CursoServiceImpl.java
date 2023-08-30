package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.repository.ICursoRepository;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {
    @Autowired
    ICursoRepository objCursoRepo;
    @Override
    public Curso crearCurso(Curso cursoCreador) {

        return objCursoRepo.save(cursoCreador);
    }

    @Override
    public Curso actualizarCurso(int id) {
        return null;
    }

    @Override
    public List<Curso> listarCurso() {
        List<Curso> listarCurso = new ArrayList<>();
        listarCurso = objCursoRepo.findAll();
        return listarCurso;
    }

    @Override
    public void eliminarCurso(int id) {

    }

    @Override
    public Curso listaCursoId(int idCurso) {
        return null;
    }
}
