package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Usuario;
import com.needhotel.modelo.exception.UsuarioInvalidoException;

import java.util.List;

public interface UsuarioDAO {

    Usuario autenticacao(String login, String senha);
    Boolean cadastrarUsuario(Usuario usuario) throws UsuarioInvalidoException;
    Boolean deletarUsuario(String cpf);
    Boolean atualizarUsuario(String cpf, Usuario usuario);
    List<Usuario> getUsuarios();

    Usuario buscarPorID(String proprietario);
}
