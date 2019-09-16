package com.needhotel.modelo.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Imovel {
    private String id;
    private String proprietario;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private Float valor;
    private boolean disponibilidade;
    private String foto;
    private String descricao;
    private List<String> comodidades;

    public Imovel() {
        id = String.valueOf(ZonedDateTime.now().toInstant().getEpochSecond());
    }

    public Imovel(String proprietario, String nome, String rua, String bairro, String numero, String cep, String cidade, String estado, Float valor, boolean disponibilidade, String foto, String descricao, List<String> comodidades){
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.valor = valor;
        this.disponibilidade = disponibilidade;
        this.foto = foto;
        this.descricao = descricao;
        this.comodidades = comodidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<String> comodidades) {
        this.comodidades = comodidades;
    }


    @Override
    public String toString() {
        return "Imovel{" +
                "id='" + id + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", valor=" + valor +
                ", disponibilidade=" + disponibilidade +
                ", foto='" + foto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", comodidades=" + comodidades +
                '}';
    }
}
