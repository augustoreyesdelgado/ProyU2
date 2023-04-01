/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 * Clase para mapear el concepto Producto de tipo Papelería
 * @author BAOZ
 */
@Entity
@DiscriminatorValue("2")
public class Usuario extends Usuarios implements Serializable{


public static final int TIPO_USUARIO = 2;
    public Usuario(){}
    
    public Usuario(String sNom, String sApp, String sApm, String sDescrip,String sTel, String sCor, String sCon){
        this.sNombre = sNom;
        this.sApellidop = sApp;
        this.sApellidom = sApm;
        this.sDireccion = sDescrip;
        this.nTelefono = sTel;
        this.nCorreo = sCor;
        this.nContrasenia = sCon;
    }
}