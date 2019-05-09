package modelo;

public class AlumnoM {

    private String CODPER;
    private String NOMPER;
    private String APEPER;
    private String DNIPER;
    private String CELPER;
    private String FECNACPER;
    private String ESTPER;
    private String COLEGIO_CODCOL;
    private String CARRERA_CODCAR;
    private String UBIGEO_CODUBI;
    private String AULA_CODAUL;

    private String CODCOL;
    private String NOMCOL;

    private String CODCAR;
    private String NOMCAR;

    /*VARIABLES COMPLEMENTARIAS*/
    private String nomCol, cantCol; //Variables para listar el top de colegios
    private String cantidadEst; //cantidad de alumnos en total registrados
    private String ALUMNOS; //REGISTRO DE TIPO  "ALUMNO"

    /*VARIABLES COMPLEMENTARIAS*/
    private String TipoCar; //tipo de carrera
    private int Caninscrt; //Cantidad de inscritos
    
    
    /*variables VISTA_CONSULTAR NOTAS RESPUESTAS*/
    private String RES1;
    private String RES2;
    private String RES3;
    private String RES4;
    private String RES5;
    private String RES6;
    private String RES7;
    private String RES8;
    private String RES9;
    private String RES10;
    private String RES11;
    private String RES12;
    private String RES13;
    
    /*variables VISTA DE CONSULTA DE SOLUCIONARIO */
    private String SOL1;
    private String SOL2;
    private String SOL3;
    private String SOL4;
    private String SOL5;
    private String SOL6;
    private String SOL7;
    private String SOL8;
    private String SOL9;
    private String SOL10;
    private String SOL11;
    private String SOL12;
    private String SOL13;
    
    /*variables vista CONSULTA DE SOLUCIONARIO_PUNTAJES*/
    
    private String PUNTAJ1;
    private String PUNTAJ2;
    private String PUNTAJ3;
    private String PUNTAJ4;
    private String PUNTAJ5;
    private String PUNTAJ6;
    private String PUNTAJ7;
    private String PUNTAJ8;
    private String PUNTAJ9;
    private String PUNTAJ10;
    private String PUNTAJ11;
    private String PUNTAJ12;
    private String PUNTAJ13;
    
    /*lista de meritos*/
    private String ALUMMERIT;
    private String CANTMERIT;
    private String PUNTJMERIT;

    public String getALUMMERIT() {
        return ALUMMERIT;
    }

    public void setALUMMERIT(String ALUMMERIT) {
        this.ALUMMERIT = ALUMMERIT;
    }

    public String getCANTMERIT() {
        return CANTMERIT;
    }

    public void setCANTMERIT(String CANTMERIT) {
        this.CANTMERIT = CANTMERIT;
    }

    public String getPUNTJMERIT() {
        return PUNTJMERIT;
    }

    public void setPUNTJMERIT(String PUNTJMERIT) {
        this.PUNTJMERIT = PUNTJMERIT;
    }
    
    

    public String getSOL1() {
        return SOL1;
    }

    public void setSOL1(String SOL1) {
        this.SOL1 = SOL1;
    }

    public String getSOL2() {
        return SOL2;
    }

    public void setSOL2(String SOL2) {
        this.SOL2 = SOL2;
    }

    public String getSOL3() {
        return SOL3;
    }

    public void setSOL3(String SOL3) {
        this.SOL3 = SOL3;
    }

    public String getSOL4() {
        return SOL4;
    }

    public void setSOL4(String SOL4) {
        this.SOL4 = SOL4;
    }

    public String getSOL5() {
        return SOL5;
    }

    public void setSOL5(String SOL5) {
        this.SOL5 = SOL5;
    }

    public String getSOL6() {
        return SOL6;
    }

    public void setSOL6(String SOL6) {
        this.SOL6 = SOL6;
    }

    public String getSOL7() {
        return SOL7;
    }

    public void setSOL7(String SOL7) {
        this.SOL7 = SOL7;
    }

    public String getSOL8() {
        return SOL8;
    }

    public void setSOL8(String SOL8) {
        this.SOL8 = SOL8;
    }

    public String getSOL9() {
        return SOL9;
    }

    public void setSOL9(String SOL9) {
        this.SOL9 = SOL9;
    }

    public String getSOL10() {
        return SOL10;
    }

    public void setSOL10(String SOL10) {
        this.SOL10 = SOL10;
    }

    public String getSOL11() {
        return SOL11;
    }

    public void setSOL11(String SOL11) {
        this.SOL11 = SOL11;
    }

    public String getSOL12() {
        return SOL12;
    }

    public void setSOL12(String SOL12) {
        this.SOL12 = SOL12;
    }

    public String getSOL13() {
        return SOL13;
    }

    public void setSOL13(String SOL13) {
        this.SOL13 = SOL13;
    }

    public String getPUNTAJ1() {
        return PUNTAJ1;
    }

    public void setPUNTAJ1(String PUNTAJ1) {
        this.PUNTAJ1 = PUNTAJ1;
    }

    public String getPUNTAJ2() {
        return PUNTAJ2;
    }

    public void setPUNTAJ2(String PUNTAJ2) {
        this.PUNTAJ2 = PUNTAJ2;
    }

    public String getPUNTAJ3() {
        return PUNTAJ3;
    }

    public void setPUNTAJ3(String PUNTAJ3) {
        this.PUNTAJ3 = PUNTAJ3;
    }

    public String getPUNTAJ4() {
        return PUNTAJ4;
    }

    public void setPUNTAJ4(String PUNTAJ4) {
        this.PUNTAJ4 = PUNTAJ4;
    }

    public String getPUNTAJ5() {
        return PUNTAJ5;
    }

    public void setPUNTAJ5(String PUNTAJ5) {
        this.PUNTAJ5 = PUNTAJ5;
    }

    public String getPUNTAJ6() {
        return PUNTAJ6;
    }

    public void setPUNTAJ6(String PUNTAJ6) {
        this.PUNTAJ6 = PUNTAJ6;
    }

    public String getPUNTAJ7() {
        return PUNTAJ7;
    }

    public void setPUNTAJ7(String PUNTAJ7) {
        this.PUNTAJ7 = PUNTAJ7;
    }

    public String getPUNTAJ8() {
        return PUNTAJ8;
    }

    public void setPUNTAJ8(String PUNTAJ8) {
        this.PUNTAJ8 = PUNTAJ8;
    }

    public String getPUNTAJ9() {
        return PUNTAJ9;
    }

    public void setPUNTAJ9(String PUNTAJ9) {
        this.PUNTAJ9 = PUNTAJ9;
    }

    public String getPUNTAJ10() {
        return PUNTAJ10;
    }

    public void setPUNTAJ10(String PUNTAJ10) {
        this.PUNTAJ10 = PUNTAJ10;
    }

    public String getPUNTAJ11() {
        return PUNTAJ11;
    }

    public void setPUNTAJ11(String PUNTAJ11) {
        this.PUNTAJ11 = PUNTAJ11;
    }

    public String getPUNTAJ12() {
        return PUNTAJ12;
    }

    public void setPUNTAJ12(String PUNTAJ12) {
        this.PUNTAJ12 = PUNTAJ12;
    }

    public String getPUNTAJ13() {
        return PUNTAJ13;
    }

    public void setPUNTAJ13(String PUNTAJ13) {
        this.PUNTAJ13 = PUNTAJ13;
    }
    
    
    

    public String getRES1() {
        return RES1;
    }

    public void setRES1(String RES1) {
        this.RES1 = RES1;
    }

    public String getRES2() {
        return RES2;
    }

    public void setRES2(String RES2) {
        this.RES2 = RES2;
    }

    public String getRES3() {
        return RES3;
    }

    public void setRES3(String RES3) {
        this.RES3 = RES3;
    }

    public String getRES4() {
        return RES4;
    }

    public void setRES4(String RES4) {
        this.RES4 = RES4;
    }

    public String getRES5() {
        return RES5;
    }

    public void setRES5(String RES5) {
        this.RES5 = RES5;
    }

    public String getRES6() {
        return RES6;
    }

    public void setRES6(String RES6) {
        this.RES6 = RES6;
    }

    public String getRES7() {
        return RES7;
    }

    public void setRES7(String RES7) {
        this.RES7 = RES7;
    }

    public String getRES8() {
        return RES8;
    }

    public void setRES8(String RES8) {
        this.RES8 = RES8;
    }

    public String getRES9() {
        return RES9;
    }

    public void setRES9(String RES9) {
        this.RES9 = RES9;
    }

    public String getRES10() {
        return RES10;
    }

    public void setRES10(String RES10) {
        this.RES10 = RES10;
    }

    public String getRES11() {
        return RES11;
    }

    public void setRES11(String RES11) {
        this.RES11 = RES11;
    }

    public String getRES12() {
        return RES12;
    }

    public void setRES12(String RES12) {
        this.RES12 = RES12;
    }

    public String getRES13() {
        return RES13;
    }

    public void setRES13(String RES13) {
        this.RES13 = RES13;
    }

    

    public String getTipoCar() {
        return TipoCar;
    }

    public void setTipoCar(String TipoCar) {
        this.TipoCar = TipoCar;
    }

    public int getCaninscrt() {
        return Caninscrt;
    }

    public void setCaninscrt(int Caninscrt) {
        this.Caninscrt = Caninscrt;
    }

    public String getALUMNOS() {
        return ALUMNOS;
    }

    public void setALUMNOS(String ALUMNOS) {
        this.ALUMNOS = ALUMNOS;
    }

    public String getCantidadEst() {
        return cantidadEst;
    }

    public void setCantidadEst(String cantidadEst) {
        this.cantidadEst = cantidadEst;
    }

    public String getNomCol() {
        return nomCol;
    }

    public void setNomCol(String nomCol) {
        this.nomCol = nomCol;
    }

    public String getCantCol() {
        return cantCol;
    }

    public void setCantCol(String cantCol) {
        this.cantCol = cantCol;
    }

    public String getCODPER() {
        return CODPER;
    }

    public void setCODPER(String CODPER) {
        this.CODPER = CODPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getAPEPER() {
        return APEPER;
    }

    public void setAPEPER(String APEPER) {
        this.APEPER = APEPER;
    }

    public String getDNIPER() {
        return DNIPER;
    }

    public void setDNIPER(String DNIPER) {
        this.DNIPER = DNIPER;
    }

    public String getCELPER() {
        return CELPER;
    }

    public void setCELPER(String CELPER) {
        this.CELPER = CELPER;
    }

    public String getFECNACPER() {
        return FECNACPER;
    }

    public void setFECNACPER(String FECNACPER) {
        this.FECNACPER = FECNACPER;
    }

    public String getESTPER() {
        return ESTPER;
    }

    public void setESTPER(String ESTPER) {
        this.ESTPER = ESTPER;
    }

    public String getCOLEGIO_CODCOL() {
        return COLEGIO_CODCOL;
    }

    public void setCOLEGIO_CODCOL(String COLEGIO_CODCOL) {
        this.COLEGIO_CODCOL = COLEGIO_CODCOL;
    }

    public String getCARRERA_CODCAR() {
        return CARRERA_CODCAR;
    }

    public void setCARRERA_CODCAR(String CARRERA_CODCAR) {
        this.CARRERA_CODCAR = CARRERA_CODCAR;
    }

    public String getUBIGEO_CODUBI() {
        return UBIGEO_CODUBI;
    }

    public void setUBIGEO_CODUBI(String UBIGEO_CODUBI) {
        this.UBIGEO_CODUBI = UBIGEO_CODUBI;
    }

    public String getAULA_CODAUL() {
        return AULA_CODAUL;
    }

    public void setAULA_CODAUL(String AULA_CODAUL) {
        this.AULA_CODAUL = AULA_CODAUL;
    }

    public String getCODCOL() {
        return CODCOL;
    }

    public void setCODCOL(String CODCOL) {
        this.CODCOL = CODCOL;
    }

    public String getNOMCOL() {
        return NOMCOL;
    }

    public void setNOMCOL(String NOMCOL) {
        this.NOMCOL = NOMCOL;
    }

    public String getCODCAR() {
        return CODCAR;
    }

    public void setCODCAR(String CODCAR) {
        this.CODCAR = CODCAR;
    }

    public String getNOMCAR() {
        return NOMCAR;
    }

    public void setNOMCAR(String NOMCAR) {
        this.NOMCAR = NOMCAR;
    }

}
