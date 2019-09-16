package integracao;

import com.needhotel.modelo.dao.implementacao.UsuarioDaoImpl;
import com.needhotel.modelo.domain.Usuario;
import com.needhotel.modelo.exception.UsuarioInvalidoException;
import org.junit.Before;
import org.junit.Test;
import org.postgresql.util.PSQLException;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class CadastroUsuarioTest {
    private UsuarioDaoImpl usuarioDao;

    @Before
    public void setUp(){
        this.usuarioDao = new UsuarioDaoImpl();
    }

    @Test
    public void usuarioValido() throws UsuarioInvalidoException {
        Usuario usuario = new Usuario("222.222.222-02", "Daniel", "Alves", "(83)99633-8557", LocalDate.now(), "daniel@daniel.com", "12345", "perfil.jpg");
        usuarioDao.cadastrarUsuario(usuario);
        Usuario usuarioRegistrado = usuarioDao.buscarPorID("222.222.222-02");
        assertNotNull(usuarioRegistrado);
    }

    @Test(expected = UsuarioInvalidoException.class)
    public void usuarioExistente() throws UsuarioInvalidoException {
        Usuario usuario = new Usuario("222.222.222-02", "Daniel", "Alves", "(83)99633-8557", LocalDate.now(), "daniel@daniel.com", "12345", "perfil.jpg");
        usuarioDao.cadastrarUsuario(usuario);;
    }

    @Test
    public void loginEmailInvalido(){
        Usuario usuario = usuarioDao.autenticacao("alealex.com", "1234");
        assertNull(usuario);
    }

    @Test
    public void loginNulo(){
        Usuario usuario = usuarioDao.autenticacao("", "");
        assertNull(usuario);
    }

    @Test
    public void loginValido(){
        Usuario usuario = usuarioDao.autenticacao("teste@teste.com", "1234");
        assertNotNull(usuario);
    }











}
