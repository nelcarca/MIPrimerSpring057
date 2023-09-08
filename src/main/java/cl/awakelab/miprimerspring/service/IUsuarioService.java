package cl.awakelab.miprimerspring.service;
import cl.awakelab.miprimerspring.entity.Usuario;
import java.util.List;

public interface IUsuarioService {

    public Usuario crearUsuario(Usuario crearUsuario);

    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado);

    public List<Usuario> listarUsuario();


    public void eliminarUsuario(int usuario);
    public void eliminarUsuario2(Usuario usuario);

    public Usuario listaUsuarioId(int idUsuario);
}
