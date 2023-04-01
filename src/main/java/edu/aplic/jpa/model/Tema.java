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
@DiscriminatorValue("3")
public class Tema extends Temas implements Serializable{


public static final int TIPO_USUARIO = 3;
    public Tema(){}
    
    public Tema(String sNom, String sApp, String sApm){
        this.sNombre = sNom;
        this.sDescripcion = sApp;
        this.sImagen = sApm;
    }
}