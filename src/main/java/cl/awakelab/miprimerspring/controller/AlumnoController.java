package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Alumno;
import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.service.IAlumnoService;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarAlumno(Model model){
        List<Alumno>listaAlumno = objAlumnoService.listarAlumno();
        List<Curso>listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributoListaAlumno", listaAlumno);
        model.addAttribute("atributolistaCurso", listaCurso);

        return "TemplateListaAlumno";
    }
    @GetMapping("/crearAlumno")
    public String mostrarFormularioCrearAlumno(Model  model){

        return "templateFormularioCrearAlumno";
    }
    @PostMapping("/crearAlumno")
    public String crearAlumno(@ModelAttribute Alumno alumno, Model model){
        List<Alumno>listaAlumno = objAlumnoService.listarAlumno();
        model.addAttribute("atributoListaAlumno", listaAlumno);
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id) {
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }

}
