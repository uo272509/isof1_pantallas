/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.is2022g33.helpers;

/**
 *
 * @author UO272509
 */
public class Cliente {
    public String nombre, apellidos;
    public String dni;
    
    public Cliente(){
    }
    public Cliente(String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    
    public static Cliente[] getClientes(int num){
        Cliente[] c = new Cliente[num];
        
        for(int i = 0; i<num; i++)
            c[i] = Cliente.random();
        
        return c;
    }
    
    public static Cliente random(){
        Cliente c = new Cliente();
        c.nombre = Nombres.randomNombre();
        c.apellidos = Nombres.randomApellidos();
        c.dni = Nombres.randomDNI();
        
        return c;
    }
}
