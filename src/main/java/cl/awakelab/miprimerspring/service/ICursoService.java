package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Curso;
import java.util.List;

public interface ICursoService {
    public Curso crearCurso(Curso cursoCreador);

    public Curso actualizarCurso(int id);

    public List<Curso> listarCurso();

    public void eliminarCurso(int id);
    public Curso listaCursoId(int idCurso);
}