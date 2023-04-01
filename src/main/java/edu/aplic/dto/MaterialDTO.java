package edu.aplic.dto;

/**
 * DTO para Material (no tiene ni tendrá anotaciones)
 * @author BAOZ
 */
public class MaterialDTO{
private int nCveMat;
private String sNombre;

    public MaterialDTO(){}
    
    public MaterialDTO(int cve, String nom){
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
