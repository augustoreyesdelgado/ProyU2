package edu.aplic.utils;

/**
 * Clase que encapsula los errores que maneja la aplicación.
 * Supone que el texto se presentará en HTML
 * @author BAOZ
 */
public class ErroresAplic {
private int nErr=-1;
public static final int NO_FIRMADO = 1;
public static final int USR_DESCONOCIDO = 2;
public static final int ERROR_EN_BD = 3;
public static final int FALTAN_DATOS = 4;
public static final int NO_EXISTE_BUSCADO = 5;
public static final int SIN_PERMISOS = 6;
public static final int ERROR_DATOS = 7;
public static final int ERROR_NAV = 8;
public static final int ARCH_NO_COPIADO = 9;
public static final int ARCH_MAYOR = 10;
public static final int ARCH_TIPO_MAL = 11;
public static final int ARCH_PROBL = 12;
    
    public int getError(){
        return this.nErr;
    }
    public void setError(int value){
        this.nErr = value;
    }
    
    public String getTextoError(){
    String sMsjError="";
        switch (nErr){
            case NO_FIRMADO: sMsjError = "No ha ingresado al sistema";
                break;
            case USR_DESCONOCIDO: sMsjError ="Usuario desconocido";
                break;
            case ERROR_EN_BD: sMsjError ="Error al acceder al repositorio";
                break;
            case FALTAN_DATOS: sMsjError = "Faltan datos";
                break;
            case NO_EXISTE_BUSCADO: sMsjError = "No existe el registro buscado";
                break;
            case SIN_PERMISOS: sMsjError = "No tiene permisos para ver la "
                    + "pantalla solicitada";
                break;
            case ERROR_DATOS: sMsjError ="Los datos son de tipo err&oacute;neo";
                break;
            case ERROR_NAV: sMsjError = "Error de navegaci&oacute;n";
                break;
            case ARCH_MAYOR: sMsjError = "El archivo es mayor a 200 KB";
                break;
            case ARCH_TIPO_MAL: sMsjError = "El archivo es de tipo incorrecto";
                break;
            case ARCH_PROBL: sMsjError = "El archivo presenta problemas";
                break;
            default: sMsjError = "Error desconocido";
        }
        return sMsjError;
    }
    
    //Para JSTL
    public int getErrFaltanDatos(){
        return ErroresAplic.FALTAN_DATOS;
    }
    public int getErrSinSesion(){
        return ErroresAplic.NO_FIRMADO;
    }
    public int getErrSinPermiso(){
        return ErroresAplic.SIN_PERMISOS;
    }
    public int getErrNav(){
        return ErroresAplic.ERROR_NAV;
    }
}
