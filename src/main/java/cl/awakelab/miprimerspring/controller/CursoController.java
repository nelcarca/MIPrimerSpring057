package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Curso;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarCurso(Model model){
        List<Curso>listaCurso = objCursoService.listarCurso();
        model.addAttribute("atributolistaCurso", listaCurso);
        return "TemplateListaCurso";
    }
    @GetMapping("/crearCurso")
    public String mostrarFormularioCrearCurso(Model model){
        return "templateFormularioCrearCurso";
    }
    @PostMapping("/crearCurso")
        public String crearCurso(@ModelAttribute Curso curso) {
        objCursoService.crearCurso(curso);
        return "redirect:/curso";
    }
    @PostMapping("/editar/{id}")
    public String editarCurso(@PathVariable int id,@ModelAttribute Curso curso){
        objCursoService.actualizarCurso(id, curso);
        return "redirect:/curso";
    }

    @GetMapping("/nombreCurso/{cursoId}")
    public ResponseEntity<String> obtenerNombreCurso(@PathVariable int cursoId) {
        // Realiza una consulta a la base de datos para obtener el nombre del curso por ID
        String nombreCurso = objCursoService.obtenerNombreCursoPorId(cursoId);

        // Verifica si se encontró el nombre del curso
        if (nombreCurso != null) {
            return ResponseEntity.ok(nombreCurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return  "redirect:/curso";
    }

}
