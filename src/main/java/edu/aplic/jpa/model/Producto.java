/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aplic.jpa.model;

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
import java.io.Serializable;

/**
 * Clase para el concepto de producto (abstracto), encapsula mapeo a BD
 * @author BAOZ
 */
@Entity
@Inheritance(
    strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(
        name="nTipoProd", 
        discriminatorType=DiscriminatorType.INTEGER)
public abstract class Producto implements Serializable{
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
@Column(name="nprecio")
protected float nPrecio;
@Column
protected String sImagen;
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="nCveMat")
protected Material oMaterial;
    public Producto(){}
    
    public Producto (String sNom, String sDescrip, float nPre, String sImg,
            Material oMat){
        this.sNombre = sNom;
        this.sDescripcion = sDescrip;
        this.nPrecio = nPre;
        this.sImagen = sImg;
        this.oMaterial = oMat;
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
            this.sDescripcion = val;
    }

    public float getPrecio(){
            return this.nPrecio;
    }
    public void setPrecio(float val){
            this.nPrecio = val;
    }

    public String getImagen(){
            return this.sImagen;
    }
    public void setImagen(String val){
            this.sImagen = val;
    }

    public Material getMaterial(){
            return this.oMaterial;
    }
    public void setMaterial(Material val){
            this.oMaterial = val;
    }
}
