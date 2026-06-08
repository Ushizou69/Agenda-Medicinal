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

//    void getDados(); 
//    Cadastro acharPorNome(); 
//    Cadastro acharPorQtdPilulas();
// A implementar
    
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

}
