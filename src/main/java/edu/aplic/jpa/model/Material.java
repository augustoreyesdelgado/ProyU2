package edu.aplic.jpa.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Concepto "Material"
 * @author BAOZ
 */
@Entity
public class Material implements Serializable{
@Id
@Column
private int nCveMat;
@Column
private String sNombre;

    public Material(){}
    
    public Material(int cve, String nom){
        this.nCveMat = cve;
        this.sNombre = nom;
    }

    public int getCveMat() {
        return nCveMat;
    }

    public void setCveMat(int val) {
        this.nCveMat = val;
    }

    public String getNombre() {
        return sNombre;
    }

    public void setNombre(String val) {
        this.sNombre = val;
    }
}
