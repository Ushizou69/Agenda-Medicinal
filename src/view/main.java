/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.*;

/**
 *
 * @author 2025001861
 */
public class main {

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Jeferson", "adshasjdha@ajshdalsdhl.com", "123456");
        Pessoa p1 = new Pessoa("Jeferson Pereira", 28, 1.80, 92.0);
        Remedio r1 = new Remedio("Ibuprufeno 500mg", "Remedio", 50, LocalDate.of(2026, 05, 02), 18.95, 1);

        Usuario u2 = new Usuario("Carlos", "carlos@gmail.com", "123456");

        Pessoa p2 = new Pessoa("Carlos Silva", 25, 1.75, 78.5);

        Remedio r2 = new Remedio("Paracetamol 750mg","Tomar 1 comprimido a cada 8 horas em caso de febre", 24, LocalDate.of(2026, 6, 25), 15.90, 3);

        CadastroDAO dao1 = new CadastroDAO();
        Cadastro c1 = new Cadastro(p1, u1, r1);
        Cadastro c2 = new Cadastro(p2, u2, r2);
        dao1.add(c1);
        dao1.add(c2);
//        System.out.println(c1);

        Tarefa t1 = new Tarefa("Anime", "Assistir O Um Pedaco com amigos na minha casa de tarde", LocalDateTime.of(2026, 06, 02, 14, 30), Categoria.PESSOAL, 2, false);
        Agenda a1 = new Agenda(LocalDateTime.of(2026, 06, 02, 14, 30), "Dia de anime", "Assistir O Um Pedaco com amigos na minha casa de tarde", t1, false);

//        System.out.println(a1);
        System.out.println(dao1.acharPorUsuario(u2));

        //Mudar agenda para focar em remedio
        //Mudar enum categoria para Antibiotico, Suplemento, Uso Continuo
        //Adicionar menu (cuidar com os try catch)
        //Criar lista de remedio no cadastro
    }
}
