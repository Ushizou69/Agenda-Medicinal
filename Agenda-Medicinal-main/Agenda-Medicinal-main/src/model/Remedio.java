/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Ushizou
 */
public class Remedio {

    private String nome;
    private String descricao;
    private static int qtdPilulas;
    private Date dataInicioMedicacao;
    private float preço;

    public Remedio(String nome, String descricao, int qtdPilulas, Date dataInicioMedicacao, float preço) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdPilulas = qtdPilulas;
        this.dataInicioMedicacao = dataInicioMedicacao;
        this.preço = preço;
    }

    public int calcularDiasRestantes(int polulasPorDia) {
    return this.qtdPilulas / pilulasPorDia;
    }

    public enum StatusRemedio {
    DISPONIVEL, ACABANDO, ESGOTADO
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static int getQtdPilulas() {
        return qtdPilulas;
    }

    public void setQtdPilulas(int qtdPilulas) {
        this.qtdPilulas = qtdPilulas;
    }

    public Date getDataInicioMedicacao() {
        return dataInicioMedicacao;
    }

    public void setDataInicioMedicacao(Date dataInicioMedicacao) {
        this.dataInicioMedicacao = dataInicioMedicacao;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }
}
