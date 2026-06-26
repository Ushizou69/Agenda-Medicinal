/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashSet;

/**
 *
 * @author Ushizou
 */
public class CadastroDAO implements OperacoesDAO<Cadastro> {

    private HashSet<Cadastro> lista = new HashSet<Cadastro>();

    @Override
    public boolean add(Cadastro c) {
        if (c instanceof Cadastro) {
            lista.add(c);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Cadastro c) {
        if (c instanceof Cadastro) {
            lista.remove(c);
            return true;
        }
        return false;
    }

    @Override
    public Cadastro find(Cadastro c) {
        if (c instanceof Cadastro) {

            for (Cadastro tarefa : lista) {

                if (tarefa.equals(c)) {
                    return tarefa;
                }
            }
        }
        return null;
    }

    public HashSet getDados() {
        return lista;
    }

    public Cadastro acharPorUsuario(Usuario usuario) {

        for (Cadastro cadastro : lista) {

            if (usuario.getNome().equals(cadastro.getUsuario().getNome())) {
                return cadastro;
            }
        }

        return null;
    }

    public Cadastro acharPorQtdPilulas(int qtdPilulas) {

        for (Cadastro cadastro : lista) {

            if (cadastro.getRemedio().getQtdPilulasAtual() == qtdPilulas) {
                return cadastro;
            }
        }

        return null;
    }
}
