/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ushizou
 */
class Cadastro {

    private Pessoa pessoa;
    private Usuario usuario;
    private static String nome;
    private Remedio remedio;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public static String getNome() {
        return nome;
    }

    public Remedio getRemedio() {
        return remedio;
    }

    public static void setNome(String nome) {
        Cadastro.nome = nome;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

}
