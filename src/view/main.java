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
    
        Cadastro c1 = new Cadastro(p1, u1, "Cadastro Jeferson", r1);
        System.out.println(c1);
        
        Tarefa t1 = new Tarefa("Anime", "Assistir O Um Pedaco com amigos na minha casa de tarde", LocalDateTime.of(2026, 06, 02, 14, 30), Categoria.PESSOAL, 2, false);
        Agenda a1 = new Agenda(LocalDateTime.of(2026, 06, 02, 14, 30), "Dia de anime", "Assistir O Um Pedaco com amigos na minha casa de tarde", t1, false);
        
        System.out.println(a1);
        
        //Mudar Doubles
        //Mudar agenda para focar em remedio
        //Mudar enum categoria para Antibiotico, Suplemento, Uso Continuo
        //Adicionar menu (cuidar com os try catch)
        //Cadastro não precisa de nome separado
        //Criar lista de remedio no cadastro
    }
}
