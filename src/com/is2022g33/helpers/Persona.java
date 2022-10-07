/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2022g33.helpers;

/**
 *
 * @author marcos
 */
public class Persona {
    private static int id_autoinc = 0;
    
    public int id;
    public String nombre, apellidos;
    public String dni;
    
    public Persona(){
    }
     
    public Persona(String nombre, String apellidos, String dni){
        this.id = Persona.nextId();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    
    public static int getId() {
        return id_autoinc;
    }
    
    public static  int nextId() {
        return id_autoinc++;
    }
    
    
    public static Persona[] getPersonas(int num){
        Persona[] c = new Persona[num];
        
        for(int i = 0; i<num; i++)
            c[i] = Persona.random();
        
        return c;
    }
    
    public static Persona random(){
       return new Persona(
               Nombres.randomNombre(),
               Nombres.randomApellidos(), 
               Nombres.randomDNI()
       );
    }
}
