/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Ushizou
 */
public class Pessoa {

    private String nome;
    private int idade;
    private Double altura;
    private Double peso;

    public Pessoa(String nome, int idade, Double altura, Double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(Double altura) { // setter ausente
        this.altura = altura;
    }

    public Double calcularIMC() {
        if (altura == 0) {
            throw new ArithmeticException("Altura não pode ser zero");
        }
        return peso / (altura * altura);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + this.idade;
        hash = 59 * hash + Objects.hashCode(this.altura);
        hash = 59 * hash + Objects.hashCode(this.peso);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.altura, other.altura)) {
            return false;
        }
        return Objects.equals(this.peso, other.peso);
    }

    @Override
    public String toString() {
        return """
           Pessoa:
            Nome: %s
            Idade: %d anos
            Altura: %.2f m
            Peso: %.2f kg
           """.formatted(nome, idade, altura, peso);
    }

}
