/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
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
//        System.out.println(u1);
//        System.out.println(p1);
//        System.out.println(r1);
        
//        r1.setQtdPilulasAtual(1);
//        
//        System.out.println(r1);
// Teste
    
        Cadastro c1 = new Cadastro(p1, u1, "Cadastro Jeferson", r1);
        System.out.println(c1);
    }
}
