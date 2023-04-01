/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.dto;

import edu.aplic.jpa.model.EnumPresentacion;
import edu.aplic.jpa.model.EnumTamanio;
/**
 * Clase para mapear el concepto Producto de tipo Papelería
 * @author BAOZ
 */
public class UsuarioDTO extends UsuariosDTO{
private EnumTamanio nTamanio;
    public UsuarioDTO(){}
    
    public UsuarioDTO(int nCve, String sNom,String sApp,String sApm, String sDescrip, String sTel, String sCor, String sCon){
        this.nClave = nCve;
        this.sNombre = sNom;
        this.sApellidop = sApp;
        this.sApellidom = sApm;
        this.sDireccion = sDescrip;
        this.nTelefono = sTel;
        this.nCorreo = sCor;
        this.nContrasenia = sCon;
    }
}