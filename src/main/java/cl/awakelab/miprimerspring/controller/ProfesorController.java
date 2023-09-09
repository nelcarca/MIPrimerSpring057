package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Profesor;
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
    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor>listaProfesor = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesor", listaProfesor);
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
    @PostMapping("/editar/{id}")
    public String editarProfesor(@PathVariable int id,@ModelAttribute Profesor profesor){
        objProfesorService.actualizarProfesor(id, profesor);
        return "redirect:/curso";
    }

    @PostMapping("/eliminar/{id}")
    public String elimnarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }

    @PostMapping("/asignarcurso/{id}")
    public String asignarCurso(@PathVariable int id,@PathVariable int idC){

        objProfesorService.asignarCurso(id, idC);
        return "redirect:/profesor";
    }
}
