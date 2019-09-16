package com.needhotel.modelo.dao.interfaces;

import com.needhotel.modelo.domain.Imovel;

import java.util.List;

public interface ImovelDao {

    Boolean cadastrarImovel(Imovel imovel);
    Boolean cadastrarFotosImovel(String imovel, String path);
    Boolean deletarImovel(String id);
    Boolean atualizarImovel(String id, Imovel imovel);
    List<Imovel> buscarPorNome(String nome);
    Imovel buscarPorID(String nome);
    List<Imovel> buscarPorCidade(String cidade);
    Boolean cadastrarComodidades(String comodidade, String imovel);






}
