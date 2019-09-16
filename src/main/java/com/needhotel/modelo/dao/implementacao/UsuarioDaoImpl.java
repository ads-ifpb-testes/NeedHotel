package com.needhotel.modelo.dao.implementacao;

import com.needhotel.modelo.domain.Usuario;
import com.needhotel.modelo.conexao.ConnectionFactory;
import com.needhotel.modelo.dao.interfaces.UsuarioDAO;
import com.needhotel.modelo.exception.UsuarioInvalidoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDAO {

    private ConnectionFactory factory;

    public UsuarioDaoImpl() {
        factory = new ConnectionFactory();
    }

    @Override
    public Usuario autenticacao(String login, String senha){
        String query = "SELECT cpf, nome, sobrenome, telefone, datanascimento, email, senha, foto " +
                "FROM usuario " +
                "WHERE email = ? AND senha = ?";
        try(Connection connection = factory.getConnection()){

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2,senha);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Usuario usuario = new Usuario(
                        resultSet.getString("cpf"),
                        resultSet.getString("nome"),
                        resultSet.getString("sobreNome"),
                        resultSet.getString("telefone"),
                        resultSet.getDate("dataNascimento").toLocalDate(),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("foto")

                );
                return usuario;
            } else return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean cadastrarUsuario(Usuario usuario) throws UsuarioInvalidoException {
        String query = "INSERT INTO usuario (cpf, nome, sobreNome, telefone, dataNascimento, email, senha, foto) VALUES (?,?,?,?,?,?,?,?)";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getCpf());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getSobreNome());
            statement.setString(4, usuario.getTelefone());
            statement.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getSenha());
            statement.setString(8, usuario.getFotoPerfil());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new UsuarioInvalidoException("Usuario ja existe");
        }
    }


    @Override
    public Boolean deletarUsuario(String cpf) {
        String query = "DELETE FROM usuario WHERE cpf = ? ";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cpf);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean atualizarUsuario(String cpf, Usuario usuario) {
        String query = "UPDATE usuario SET cpf = ?, nome = ?, sobrenome = ?, telefone = ?, datanascimento = ?, " +
                "email = ?, senha = ?, foto = ? WHERE cpf = ?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getCpf());
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getSobreNome());
            statement.setString(4, usuario.getTelefone());
            statement.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getSenha());
            statement.setString(8, usuario.getFotoPerfil());
            statement.setString(9, cpf);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Usuario> getUsuarios() {
        String query = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                usuarios.add(new Usuario(
                        resultSet.getString("cpf"),
                        resultSet.getString("nome"),
                        resultSet.getString("sobrenome"),
                        resultSet.getString("telefone"),
                        resultSet.getDate("dataNascimento").toLocalDate(),
                        resultSet.getString("email"),
                        resultSet.getString("senha"),
                        resultSet.getString("foto")
                ));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Usuario buscarPorID(String proprietario) {
        String query = "SELECT * FROM usuario WHERE cpf ILIKE ?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, proprietario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setNome(resultSet.getString("nome"));
                usuario.setFotoPerfil(resultSet.getString("foto"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean verificaCpf(String cpf){
        String query = "SELECT * FROM usuario WHERE cpf = ?";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean verificarEmail(String email){
        String query = "SELECT * FROM usuario WHERE email = ?";

        try (Connection connection = factory.getConnection()){

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}



