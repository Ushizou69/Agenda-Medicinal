/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ushizou
 */
public class Cadastro {

    private Pessoa pessoa;
    private Usuario usuario;
    private List<Remedio> remedios;

    public Cadastro(Pessoa pessoa, Usuario usuario, Remedio remedio) {
        this.pessoa = pessoa;
        this.usuario = usuario;
        this.remedios.add(remedio);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void adicionarRemedio(Remedio remedio) {
        if (remedio != null) {
            remedios.add(remedio);
        }
    }
    
    public boolean removerRemedio(Remedio remedio) {
        return remedios.remove(remedio);
    }

    public void setRemedio(Remedio remedio) {
        if (remedios.isEmpty()) {
            remedios.add(remedio);
        } else {
            remedios.set(0, remedio);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pessoa);
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.remedios);
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
        return Objects.equals(this.remedios, other.remedios);
    }

    @Override
    public String toString() {
        StringBuilder sbRemedios = new StringBuilder();
        for (Remedio r : remedios) {
            sbRemedios.append(r.toString()).append("\n");
        }

        return """
           ========================================
                     DADOS DO CADASTRO
           ========================================
           
           %s
           
           %s
           
           Remedios cadastrados (%d):
           %s
           ========================================
           """.formatted(
                pessoa,
                usuario,
                remedios.size(),
                sbRemedios.toString()
        );
    }

}
