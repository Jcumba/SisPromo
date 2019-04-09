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
    
    
    /*variables VISTA_CONSULTAR NOTAS*/
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
