package edu.aplic.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 * Clase para mapear el concepto Producto de Uso Personal
 * @author BAOZ
 */
@Entity
@DiscriminatorValue("0")
public class UsoPersonal extends Producto implements Serializable{
@Column
private EnumTamanio nTamanio;
@Column
private String nAuxiliar;

public static final int TIPO_USO_PERSONAL = 0;

    public UsoPersonal(){}
    
    public UsoPersonal(String sNom, String sDescrip, float nPre,
            String sImg, Material oM, EnumTamanio nTam){
        this.sNombre = sNom;
        this.sDescripcion = sDescrip;
        this.nPrecio = nPre;
        this.sImagen = sImg;
        this.oMaterial = oM;
        this.nTamanio = nTam;
        this.nAuxiliar = "ses";
    }
    
    public EnumTamanio getTamanio(){
        return this.nTamanio;
    }
    public void setTamanio(EnumTamanio val){
        this.nTamanio = val;
    }
    public String getAux(){
        return this.nAuxiliar;
    }
    public void setAux(String val){
        this.nAuxiliar = val;
    }
}
