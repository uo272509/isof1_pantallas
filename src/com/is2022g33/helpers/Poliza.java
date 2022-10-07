/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.is2022g33.helpers;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author marcos
 */
public class Poliza {
    private static ArrayList<String> ramos = new ArrayList<String>();
    
    public static String[] getRamos(){
        if (ramos.isEmpty()) {
            ramos.add("Automóvil");
            ramos.add("Vida");
            ramos.add("Hogar");
            ramos.add("Accidentes");
        }
        
        return ramos.toArray(new String[ramos.size()]);
    }
    
    public static String getRamo(int i) {
        if (i > ramos.size())
            return null;
        
        return ramos.get(i);
    }
    
    public static int randomRamo(Random rand) {
        return rand.nextInt(getRamos().length);
    }
    
    public static void addRamo(String ramo) {
        ramos.add(ramo);
    }
    
    public static boolean removeRamo(String ramo) {
        int i = ramos.indexOf(ramo);
        
        if (i == -1)
            return false;
        
        ramos.remove(i);
        
        return true;
    }
    
    public static enum Cobro {
        anual,
        semestral,
        trimestral
    }
    
    public Cobro tipo_cobro;
    private Persona cliente, colaborador;
    public String descripcion;
    public int ramo;
    
    public Poliza(Cobro cobro, Persona cliente, Persona colaborador, int ramo){
        this.tipo_cobro = cobro;
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.ramo = ramo;
    }
    
    public Poliza(Persona[] posibles_clientes, Persona[] posibles_colaboradores) {
        Random rand = new Random();
        
        this.tipo_cobro = Cobro.values()[rand.nextInt(Cobro.values().length)];
        this.cliente = posibles_clientes[rand.nextInt(posibles_clientes.length)];
        this.colaborador = posibles_colaboradores[rand.nextInt(posibles_colaboradores.length)];
        this.ramo = Poliza.randomRamo(rand);
    }

    public String getCobroStr() {
        return tipo_cobro.name();
    }
    
    public Cobro getCobro() {
        return tipo_cobro;
    }

    public void setCobro(Cobro tipo_cobro) {
        this.tipo_cobro = tipo_cobro;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Persona getColaborador() {
        return colaborador;
    }

    public void setColaborador(Persona colaborador) {
        this.colaborador = colaborador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRamo() {
        return Poliza.getRamo(ramo);
    }
    
    public int getRamoIndex() {
        return ramo;
    }

    public void setRamo(int ramo) {
        if(ramo > 0 && ramo < ramos.size()-1)
            this.ramo = ramo;
    }
    
    public static Poliza[] getPolizas(Persona[] posibles_clientes, Persona[] posibles_colaboradores, int number) {
        Poliza[] polizas = new Poliza[number];
        
        for(int i = 0; i<number; i++)
            polizas[i] = new Poliza(posibles_clientes, posibles_colaboradores);
        
        return polizas;
    }
}
