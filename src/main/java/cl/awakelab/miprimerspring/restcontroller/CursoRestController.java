package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursoCreado")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;
    @PostMapping
    public Curso crearCurso(@RequestBody Curso cursoCreado){
        return objCursoService.crearCurso(cursoCreado);
    }
    @GetMapping("/{id}")
    public Curso listarCursoid(@PathVariable int id){
        return objCursoService.listaCursoId(id);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso){
        return objCursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
    }

    @GetMapping
    public List<Curso> listarCurso(){
        return objCursoService.listarCurso();
    }
}
