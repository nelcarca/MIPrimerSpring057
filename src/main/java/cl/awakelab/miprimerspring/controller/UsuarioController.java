package cl.awakelab.miprimerspring.controller;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario>listaUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuario", listaUsuarios);
        return "templateListarUsuarios";
    }
    @GetMapping("/crearUsuario")
    public String MostarFormularioCrearUsuario(Model model){

        return "templateFormularioCrearUsuario";
    }
    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }
    @PostMapping("/editar/{id}")
    public String editarUsuario(@PathVariable int id,@ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario(id, usuario);
        return "redirect:/usuario";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuario";
    }
}
