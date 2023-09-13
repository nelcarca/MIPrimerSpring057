package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnoCreado")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumnoCreado){
        return objAlumnoService.crearAlumno(alumnoCreado);
    }
    @GetMapping("/{id}")
    public Alumno listarAlumnoId(@PathVariable int id){
        return objAlumnoService.listaAlumnoId(id);
    }
    @PutMapping("{id}")
    public Alumno actualizarAlumno(@PathVariable int id, @RequestBody Alumno alumno){
        return objAlumnoService.actualizarAlumno(id, alumno);
    }
    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
    }
    @GetMapping
    public List<Alumno> listarAlumno(){
        return objAlumnoService.listarAlumno();
    }
}
