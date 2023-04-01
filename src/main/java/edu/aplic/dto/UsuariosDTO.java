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
public class UsuariosDTO{
protected int nClave;
protected String sNombre;
protected String sApellidop;
protected String sApellidom;
protected String sDireccion;
protected float nPrecio;
@Pattern(regexp="[0-9]{10}",message="length must be 3")  
protected String nTelefono;
protected String nCorreo;
protected String nContrasenia;
protected MaterialDTO oMaterial=new MaterialDTO();
    
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
    
    public String getApellidom(){
            return this.sApellidom;
    }
    public void setApellidom(String val){
            this.sApellidom= val;
    }
    
    public String getApellidop(){
            return this.sApellidop;
    }
    public void setApellidop(String val){
            this.sApellidop = val;
    }

    public String getDireccion(){
            return this.sDireccion;
    }
    public void setDireccion(String val){
            this.sDireccion= val;
    }

    public float getPrecio(){
            return this.nPrecio;
    }
    public void setPrecio(float val){
            this.nPrecio = val;
    }

    
    public String getTelefono(){
            return this.nTelefono;
    }
    public void setTelefono(String val){
            this.nTelefono = val;
    }
    public String getCorreo(){
            return this.nCorreo;
    }
    public void setCorreo(String val){
            this.nCorreo = val;
    }
    public String getContrasenia(){
            return this.nContrasenia;
    }
    public void setContrasenia(String val){
            this.nContrasenia = val;
    }
}
