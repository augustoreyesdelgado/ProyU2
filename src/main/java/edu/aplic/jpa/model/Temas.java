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
public class Temas implements Serializable{
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
protected String sDescripcion;
@Column
protected String sImagen;
    public Temas(){}
    
    public Temas (String sNom, String sApp, String sApm){
        this.sNombre = sNom;
        this.sDescripcion = sApp;
        this.sImagen = sApm;
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