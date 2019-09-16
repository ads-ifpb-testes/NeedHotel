package com.needhotel.modelo.dao.implementacao;

import com.needhotel.modelo.conexao.ConnectionFactory;
import com.needhotel.modelo.dao.interfaces.ImovelDao;
import com.needhotel.modelo.domain.Imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImovelDaoImpl implements ImovelDao {

    ConnectionFactory factory;

    public ImovelDaoImpl() {
        factory = new ConnectionFactory();
    }

    @Override
    public Boolean cadastrarImovel(Imovel imovel) {
        String query = "INSERT INTO imovel(id, proprietario, nome, rua, bairro, numero, cep, cidade, estado, valor, disponibilidade, foto, descricao) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, imovel.getId());
            statement = setStatement(statement, imovel);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean cadastrarFotosImovel(String imovel, String path) {
        String query = "INSERT INTO foto(id_imovel, foto) VALUES (?,?)";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, imovel);
            statement.setString(2, path);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletarImovel(String id) {
        String query = "DELETE FROM imovel WHERE id = ?";
        String query1 = "DELETE FROM foto WHERE id_imovel = ?";
        String query2 = "DELETE FROM comodidade WHERE id_imovel = ?";
        try (Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            PreparedStatement statement1 = connection.prepareStatement(query1);
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement.setString(1, id);
            statement1.setString(1, id);
            statement2.setString(1, id);

            return statement.executeUpdate() > 0 && statement1.executeUpdate() > 0 &&  statement2.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean atualizarImovel(String id, Imovel imovel) {
        String query = "UPDATE imovel" +
                " SET id=?, proprietario=?, nome=?, rua=?, bairro=?, numero=?, cep=?, cidade=?, estado=?, valor=?, disponibilidade=?, foto=?, descricao=?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement = setStatement(statement, imovel);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Imovel> buscarPorNome(String nome) {
        String query = "SELECT * FROM imovel WHERE nome ILIKE ?";
        List<Imovel> imoveis;
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%"+nome+"%");
            ResultSet resultSet = statement.executeQuery();
            imoveis = setListaImoveis(resultSet);
            return imoveis;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Imovel buscarPorID(String nome) {
        String query = "SELECT * FROM imovel WHERE id ILIKE ?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Imovel imovel = getResult(resultSet);
                return imovel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Imovel> buscarPorCidade(String cidade) {
        String query = "SELECT * FROM imovel WHERE cidade ILIKE ?";
        List<Imovel> imoveis;
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%"+cidade+"%");
            ResultSet resultSet = statement.executeQuery();
            imoveis = setListaImoveis(resultSet);
            return imoveis;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Imovel> buscaPorUsuario(String idUsuario){
        String query = "SELECT * FROM imovel WHERE proprietario = ?";
        List<Imovel> imoveis;

        try (Connection connection = factory.getConnection();){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            imoveis = setListaImoveis(resultSet);
            return imoveis;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean cadastrarComodidades(String comodidade, String imovel) {
        String query = "INSERT INTO comodidade(id_imovel, recurso) VALUES (?,?)";
        try(Connection connection = factory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, imovel);
            statement.setString(2, comodidade);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Imovel> setListaImoveis(ResultSet resultSet) throws SQLException {
        List<Imovel> imoveis = new ArrayList<>();
        while (resultSet.next()){
            Imovel imovel = getResult(resultSet);
            imoveis.add(imovel);
        }
        return imoveis;
    }

    private Imovel getResult(ResultSet resultSet){
        Imovel imovel = new Imovel();
        try {
            imovel.setId(resultSet.getString("id"));
            imovel.setProprietario(resultSet.getString("proprietario"));
            imovel.setNome(resultSet.getString("nome"));
            imovel.setRua(resultSet.getString("rua"));
            imovel.setBairro(resultSet.getString("bairro"));
            imovel.setNumero(resultSet.getString("numero"));
            imovel.setCep(resultSet.getString("cep"));
            imovel.setCidade(resultSet.getString("cidade"));
            imovel.setEstado(resultSet.getString("estado"));
            imovel.setValor(resultSet.getFloat("valor"));
            imovel.setDisponibilidade(resultSet.getBoolean("disponibilidade"));
            imovel.setFoto(resultSet.getString("foto"));
            imovel.setDescricao(resultSet.getString("descricao"));
            imovel.setComodidades(getComodidades(imovel.getId()));
            return imovel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getfotos(String imovel){
        List<String> fotos = new ArrayList<>();
        String query = "SELECT foto FROM foto WHERE id_imovel = ?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, imovel);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                fotos.add(resultSet.getString("foto"));
            }
        return fotos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getComodidades(String imovel){
        List<String> comodidades = new ArrayList<>();
        String query = "SELECT recurso FROM comodidade WHERE id_imovel = ?";
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, imovel);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                comodidades.add(resultSet.getString("recurso"));
            }
            return comodidades;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PreparedStatement setStatement(PreparedStatement statement, Imovel imovel) throws SQLException {
        statement.setString(2, imovel.getProprietario());
        statement.setString(3, imovel.getNome());
        statement.setString(4, imovel.getRua());
        statement.setString(5, imovel.getBairro());
        statement.setString(6, imovel.getNumero());
        statement.setString(7, imovel.getCep());
        statement.setString(8, imovel.getCidade());
        statement.setString(9, imovel.getEstado());
        statement.setFloat(10, imovel.getValor());
        statement.setBoolean(11, imovel.isDisponibilidade());
        statement.setString(12, imovel.getFoto());
        statement.setString(13, imovel.getDescricao());
        return statement;
    }
}
