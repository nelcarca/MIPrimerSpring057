package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.service.ICursoService;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor>listaProfesor = objProfesorService.listarProfesor();
        List<Curso>listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributoListaProfesor", listaProfesor);
        model.addAttribute("atributolistaCurso", listaCurso);
        return "TemplateListaProfesor";
    }
    @GetMapping("/crearProfesor")
    public String mostrarFormularioCrearProfesor(Model model){

        return "templateFormularioCrearProfesor";
    }
    @PostMapping("/crearProfesor")
    public String crearProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }
    @PostMapping("/asignarCurso")
    public String asignarCursoAProfesor(@RequestParam("idProfe") int idProfe,
                                        @RequestParam("cursoId") int cursoId, Model model){
        System.out.println("primerProfesor " + idProfe);
        List<Curso> listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributolistaCurso", listaCurso);
        objProfesorService.asignarCursoAProfesor(idProfe, cursoId);
        return "redirect:/profesor";
    }
    @PostMapping("/editar/{id}")
    public String editarProfesor(@PathVariable int id,@ModelAttribute Profesor profesor){
        objProfesorService.actualizarProfesor(id, profesor);
        return "redirect:/profesor";
    }

    @PostMapping("/eliminar/{id}")
    public String elimnarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }

}
