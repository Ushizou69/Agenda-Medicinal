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
public class Cadastro {

    private Pessoa pessoa;
    private Usuario usuario;
    private Remedio remedio;

    public Cadastro(Pessoa pessoa, Usuario usuario, Remedio remedio) {
        this.pessoa = pessoa;
        this.usuario = usuario;
        this.remedio = remedio;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public Remedio getRemedio() {
        return remedio;
    }

    public void setRemedio(Remedio remedio) {
        this.remedio = remedio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pessoa);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.remedio);
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
        final Cadastro other = (Cadastro) obj;
        
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.remedio, other.remedio);
    }

    @Override
    public String toString() {
        return """
           ========================================
                     DADOS DO CADASTRO
           ========================================
           
           %s
           
           %s
           
           %s
           ========================================
           """.formatted(
                pessoa,
                usuario,
                remedio
        );
    }

}
