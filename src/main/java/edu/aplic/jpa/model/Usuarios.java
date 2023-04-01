/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.jpa.model;

/**
 *
 * @author augus
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Inheritance(
    strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(
        name="nTipoProd", 
        discriminatorType=DiscriminatorType.INTEGER)
public class Usuarios implements Serializable{
@Id
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "id_gen_prod"
)
@SequenceGenerator(
        name= "id_gen_prod",
        sequenceName = "producto_ncveprod_seq",
        initialValue=7, allocationSize=1
)
@Column(name="nCveProd")
protected int nClave;
@Column
protected String sNombre;
@Column
protected String sApellidop;
@Column
protected String sApellidom;
@Column
protected String sDireccion;
@Column
@Pattern(regexp="[0-9]{10}", message="Falta elegir tipo de producto")
protected String nTelefono;
@Column
protected String nCorreo;
@Column
protected String nContrasenia;
    public Usuarios(){}
    
    public Usuarios (String sNom, String sApp, String sApm, String sDescrip,String sTel, String sCor, String sCon){
        this.sNombre = sNom;
        this.sApellidop = sApp;
        this.sApellidom = sApm;
        this.sDireccion = sDescrip;
        this.nTelefono = sTel;
        this.nCorreo = sCor;
        this.nContrasenia = sCon;
    }
    
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
            this.sDireccion = val;
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

