/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.TreeSet;

/**
 *
 * @author Ushizou
 */
public class CadastroDAO implements OperacoesDAO<Cadastro> {

    private TreeSet<Cadastro> lista = new TreeSet<Cadastro>();

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

    public TreeSet getDados() {
        return lista;
    }

    public Cadastro acharPorNome(String nome) {

        for (Cadastro cadastro : lista) {

            if (nome.equals(Cadastro.getNome())) {
                return cadastro;
            }
        }

        return null;
    }

    public Cadastro acharPorQtdPilulas(int qtdPilulas) {

        for (Cadastro cadastro : lista) {

            if (qtdPilulas == Remedio.getQtdPilulas()) {
                return cadastro;
            }
        }

        return null;
    }
}
