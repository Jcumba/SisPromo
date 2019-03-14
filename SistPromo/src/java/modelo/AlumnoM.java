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
