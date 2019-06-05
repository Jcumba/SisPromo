 package modelo;

import java.sql.Date;

public class CronogramaM {

    private String CODEXA;
    private String FECCROEXA;
    private String HORCROEXA;
    private String TIPEXA,MODEXA,SOLUCIONARIO_CODSOL;
    Date FECINC;
    java.util.Date fechaTemporal;

    public String getCODEXA() {
        return CODEXA;
    }

    public void setCODEXA(String CODEXA) {
        this.CODEXA = CODEXA;
    }

    public String getHORCROEXA() {
        return HORCROEXA;
    }

    public void setHORCROEXA(String HORCROEXA) {
        this.HORCROEXA = HORCROEXA;
    }

    public String getFECCROEXA() {
        return FECCROEXA;
    }

    public void setFECCROEXA(String FECCROEXA) {
        this.FECCROEXA = FECCROEXA;
 
    }

    public Date getFECINC() {
        return FECINC;
    }

    public void setFECINC(Date FECINC) {
        this.FECINC = FECINC;
    }

    public java.util.Date getFechaTemporal() {
        return fechaTemporal;
    }

    public void setFechaTemporal(java.util.Date fechaTemporal) {
        this.fechaTemporal = fechaTemporal;
 
    }

    public String getTIPEXA() {
        return TIPEXA;
    }

    public void setTIPEXA(String TIPEXA) {
        this.TIPEXA = TIPEXA;
    }

    public String getMODEXA() {
        return MODEXA;
    }

    public void setMODEXA(String MODEXA) {
        this.MODEXA = MODEXA;
    }

    public String getSOLUCIONARIO_CODSOL() {
        return SOLUCIONARIO_CODSOL;
    }

    public void setSOLUCIONARIO_CODSOL(String SOLUCIONARIO_CODSOL) {
        this.SOLUCIONARIO_CODSOL = SOLUCIONARIO_CODSOL;
    }

}
