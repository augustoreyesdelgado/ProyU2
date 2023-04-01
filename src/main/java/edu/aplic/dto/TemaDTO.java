/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.dto;

/**
 *
 * @author augus
 */
public class TemaDTO extends TemasDTO{
    public TemaDTO(){}
    
    public TemaDTO(int nCve, String sNom,String sApp,String sApm){
        this.nClave = nCve;
        this.sNombre = sNom;
        this.sDescripcion = sApp;
        this.sImagen = sApm;
    }
}