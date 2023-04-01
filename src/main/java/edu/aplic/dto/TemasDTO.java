/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.dto;

import jakarta.validation.constraints.Pattern;

/**
 *
 * @author augus
 */
public class TemasDTO{
protected int nClave;
protected String sNombre;
protected String sDescripcion;
protected String sImagen;
    
    public int getClave(){
            return this.nClave;
    }
    public void setClave(int val){
            this.nClave = val;
    }

    public String getNombre(){
            return this.sNombre;
    }
    public void setNombre(String val){
            this.sNombre = val;
    }

    public String getDescripcion(){
            return this.sDescripcion;
    }
    public void setDescripcion(String val){
            this.sDescripcion= val;
    }
    
    public String getImagen(){
            return this.sImagen;
    }
    public void setImagen(String val){
            this.sImagen = val;
    }
}