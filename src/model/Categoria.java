/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author 2025001861
 */
public enum Categoria {
    PESSOAL ("pessoal"), 
    TRABALHO ("trabalho"),
    FAMILIA ("familia");
    
    String uso;
    
    private Categoria (String uso){
        this.uso = uso;
    }
    
    public String getUso(){
        return uso;
    }
    
}
