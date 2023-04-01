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
@DiscriminatorValue("1")
public class Papeleria extends Producto implements Serializable{
@Column
private EnumPresentacion nPresentacion;

public static final int TIPO_PAPELERIA = 1;
    public Papeleria(){}
    
    public Papeleria(String sNom, String sDescrip, float nPre,
            String sImg, Material oM, EnumPresentacion nPres){
        this.sNombre = sNom;
        this.sDescripcion = sDescrip;
        this.nPrecio = nPre;
        this.sImagen = sImg;
        this.oMaterial = oM;
        this.nPresentacion = nPres;
    }
    
    public EnumPresentacion getPresentacion(){
        return this.nPresentacion;
    }
    public void setPresentacion(EnumPresentacion val){
        this.nPresentacion = val;
    }
}
