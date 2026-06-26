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
    ANTIBIOTICO ("Antibiotico"), 
    SUPLEMENTO ("Suplemento"),
    USO_CONTINUO ("Uso Continuo");
    
    String uso;
    
    private Categoria (String uso){
        this.uso = uso;
    }
    
    public String getUso(){
        return uso;
    }
    
}
