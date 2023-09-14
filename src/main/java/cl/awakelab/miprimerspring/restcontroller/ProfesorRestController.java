package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesorCreado")
public class ProfesorRestController {
    @Autowired
    IProfesorService objProfesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody Profesor profesorCreado){
        return objProfesorService.crearProfesor(profesorCreado);
    }
    @GetMapping("/{id}")
    public Profesor listarProfesorId(@PathVariable int id) {

        return objProfesorService.listaProfesorId(id);
    }

    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable int id, @RequestBody Profesor profesor){
        return objProfesorService.actualizarProfesor(id, profesor);
    }
    @PostMapping("/asignarCurso/{cursoId}")
    public Profesor asignarCursoAProfesor(@PathVariable int id, @PathVariable int cursoId){
        return objProfesorService.asignarCursoAProfesor(id, cursoId);
    }
    @DeleteMapping("/{id}")
    public void eliminarProfesor(@PathVariable int id){

        objProfesorService.eliminarProfesor(id);
    }
    @GetMapping
    public List<Profesor> listarProfesor(){
        return  objProfesorService.listarProfesor();
    }
}
