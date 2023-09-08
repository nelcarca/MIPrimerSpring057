package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.repository.IProfesorRepository;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service ("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    IProfesorRepository objPrefesorRepo;
    @Override
    public Profesor crearProfesor(Profesor profesorCreador) {
        Profesor nuevoProfesor = new Profesor();
        nuevoProfesor = objPrefesorRepo.save(profesorCreador);
        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(int id, Profesor profesorActualizado) {
        Profesor profesorEncontrado = objPrefesorRepo.findById(id).orElse(null);
        profesorEncontrado.setNombres(profesorActualizado.getNombres());
        profesorEncontrado.setApellido1(profesorActualizado.getApellido1());
        profesorEncontrado.setApellido2(profesorActualizado.getApellido2());
        return null;
    }

    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaMuestra = new ArrayList<>();
        listaMuestra = objPrefesorRepo.findAll();
        return listaMuestra;
    }

    @Override
    public void eliminarProfesor(int id) {
    objPrefesorRepo.deleteById(id);
    }

    @Override
    public Profesor listaProfesorId(int idProfesor) {

        return objPrefesorRepo.findById(idProfesor).orElse(null);
    }
}
