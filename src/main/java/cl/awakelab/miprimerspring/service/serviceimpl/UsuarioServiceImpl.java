package cl.awakelab.miprimerspring.service.serviceimpl;
import cl.awakelab.miprimerspring.entity.Usuario;
import cl.awakelab.miprimerspring.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service ("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario crearUsuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario = objUsuarioRepo.save(crearUsuario);
        return nuevoUsuario;
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado) {
        Usuario usuarioParaActualizar = objUsuarioRepo.findById(id).orElse(null);
        usuarioParaActualizar.setNombreUsuario(usuarioActualizado.getNombreUsuario());
        usuarioParaActualizar.setContrasena(usuarioActualizado.getContrasena());
        usuarioParaActualizar.setRol(usuarioActualizado.getRol());
        return objUsuarioRepo.save(usuarioParaActualizar);
    }

    @Override
    public List<Usuario> listarUsuario() {
        List<Usuario> listarUsuario = new ArrayList<>();
        listarUsuario = objUsuarioRepo.findAll();
        return listarUsuario;
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }

    @Override
    public void eliminarUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }

    @Override
    public Usuario listaUsuarioId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElse(null);
    }
}
