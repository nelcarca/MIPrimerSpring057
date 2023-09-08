package cl.awakelab.miprimerspring.restcontroller;

import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarioCreador")

public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuarioCreador){
        return objUsuarioService.crearUsuario(usuarioCreador);
    }
    @GetMapping("/{id}")
    public Usuario listarUsuarioId(@PathVariable int id) {
        return objUsuarioService.listaUsuarioId(id);
    }
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return objUsuarioService.actualizarUsuario(id, usuario);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
    }
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return  objUsuarioService.listarUsuario();
    }
}
