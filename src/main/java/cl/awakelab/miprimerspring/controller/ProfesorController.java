package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Profesor;
import cl.awakelab.miprimerspring.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Profesor")
public class ProfesorController {
    @Autowired
    IProfesorService objProfesorService;
    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor>listaPrefesor = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfesor", listaPrefesor);
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

    @PostMapping("/eliminar/{id}")
    public String elimnarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }
}