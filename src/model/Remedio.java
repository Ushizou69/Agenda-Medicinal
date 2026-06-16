/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Objects;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Ushizou
 */
public class Remedio {

    private String nome;
    private String descricao;
    private int qtdPilulasAtual;
    private LocalDate dataInicioMedicacao;
    private LocalDate dataFinalMedicacao;
    private Double preco;
    private int pilulasPorDia;

    public Remedio(String nome, String descricao, int qtdPilulas, LocalDate dataInicioMedicacao, Double preco, int pilulasPorDia) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtdPilulasAtual = qtdPilulas;
        this.dataInicioMedicacao = dataInicioMedicacao;
        this.preco = preco;
        this.pilulasPorDia = pilulasPorDia;
        calcularDataFinalMedicacao();
    }

    public int calcularDiasRestantes(int pilulasPorDia) {
        return this.qtdPilulasAtual / pilulasPorDia;
    }

    public void tomarDose() {
        if (qtdPilulasAtual > 0) {
            qtdPilulasAtual -= pilulasPorDia;
        }
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

    public int getQtdPilulasAtual() {
        return qtdPilulasAtual;
    }

    public void setQtdPilulasAtual(int qtdPilulasAtual) {
        this.qtdPilulasAtual = qtdPilulasAtual;
    }

    public LocalDate getDataInicioMedicacao() {
        return dataInicioMedicacao;
    }

    public void setDataInicioMedicacao(LocalDate dataInicioMedicacao) {
        this.dataInicioMedicacao = dataInicioMedicacao;
    }

    public LocalDate getDataFinalMedicacao() {
        return dataFinalMedicacao;
    }

    public void calcularDataFinalMedicacao() {
        this.dataFinalMedicacao = dataInicioMedicacao.plusDays(calcularDiasRestantes(pilulasPorDia));
    }

    public String getPrazoMedicacao() {
        LocalDate hoje = LocalDate.now();

        if (hoje.isAfter(dataFinalMedicacao)) {
            return "Prazo expirado";
        }

        return "Dentro do prazo";
    }

    public String getStatusMedicacao() {
        if (qtdPilulasAtual <= 0) {
            return "Medicao acabou!";
        }

        if (qtdPilulasAtual <= 5) {
            return "Atencao: medicamento acabando!";
        }

        return "Estoque normal";
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getPilulasPorDia() {
        return pilulasPorDia;
    }

    public void setPilulasPorDia(int pilulasPorDia) {
        this.pilulasPorDia = pilulasPorDia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.dataInicioMedicacao);
        hash = 23 * hash + Objects.hashCode(this.dataFinalMedicacao);
        hash = 23 * hash + Objects.hashCode(this.preco);
        hash = 23 * hash + this.pilulasPorDia;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Remedio other = (Remedio) obj;
        if (this.pilulasPorDia != other.pilulasPorDia) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioMedicacao, other.dataInicioMedicacao)) {
            return false;
        }
        if (!Objects.equals(this.dataFinalMedicacao, other.dataFinalMedicacao)) {
            return false;
        }
        return Objects.equals(this.preco, other.preco);
    }

    @Override
    public String toString() {
        return """
           Remedio:
           Nome              : %s
           Descricao         : %s
           Quantidade Atual  : %d pilulas
           Inicio da Medicacao: %s
           Fim da Medicacao  : %s
           Preco             : R$ %.2f
           Pilulas por Dia   : %d
           Prazo             : %s
           Status            : %s
           """.formatted(
                nome,
                descricao,
                qtdPilulasAtual,
                dataInicioMedicacao,
                dataFinalMedicacao,
                preco,
                pilulasPorDia,
                getPrazoMedicacao(),
                getStatusMedicacao()
        );
    }

}
