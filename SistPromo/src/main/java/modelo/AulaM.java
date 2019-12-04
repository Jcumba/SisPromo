package modelo;

import java.sql.Date;

public class AulaM {

    private String CODAUL;
    private String NUMAUL;
    private String AFORAUL;
    private String ESTAUL;
    private String EXAMEN_CODEXA, HORCROEXA, MODEXA,TIPEXA;
    
    
    private String CANTAUL;

    Date FECINC;
    java.util.Date fechaTemporal;

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

    public String getCODAUL() {
        return CODAUL;
    }

    public void setCODAUL(String CODAUL) {
        this.CODAUL = CODAUL;
    }

    public String getNUMAUL() {
        return NUMAUL;
    }

    public void setNUMAUL(String NUMAUL) {
        this.NUMAUL = NUMAUL;
    }

    public String getAFORAUL() {
        return AFORAUL;
    }

    public void setAFORAUL(String AFORAUL) {
        this.AFORAUL = AFORAUL;
    }

    public String getESTAUL() {
        return ESTAUL;
    }

    public void setESTAUL(String ESTAUL) {
        this.ESTAUL = ESTAUL;
    }

    public String getEXAMEN_CODEXA() {
        return EXAMEN_CODEXA;
    }

    public void setEXAMEN_CODEXA(String EXAMEN_CODEXA) {
        this.EXAMEN_CODEXA = EXAMEN_CODEXA;
    }


    public String getHORCROEXA() {
        return HORCROEXA;
    }

    public void setHORCROEXA(String HORCROEXA) {
        this.HORCROEXA = HORCROEXA;
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

    public String getCANTAUL() {
        return CANTAUL;
    }

    public void setCANTAUL(String CANTAUL) {
        this.CANTAUL = CANTAUL;
    }

    
    
 
}
