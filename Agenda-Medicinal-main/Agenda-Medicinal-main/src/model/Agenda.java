/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Ushizou
 */
public class Agenda {
    
    Date data;
    String nome; 
    String descricao;
    private PrioridadeTarefa prioridade;
    private boolean concluida;
}

public enum PrioridadeTarefa { //adicionado
    BAIXA, MEDIA, ALTA, URGENTE
}
