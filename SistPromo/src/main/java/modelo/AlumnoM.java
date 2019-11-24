package modelo;

import lombok.Data;




@Data
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
    private String AULA_CODAUL,FECCROEXA,HORCROEXA,MODEXA,NOMTIPEXA,NUMAUL,DISTRITO;
    
    private String ALUMNO;
    
    private String CODCOL;
    private String NOMCOL;

    private String CODCAR;
    private String NOMCAR;

    /*VARIABLES COMPLEMENTARIAS*/
    private String NomCol;
    private String  cantCol; //Variables para listar el top de colegios
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
    

    
}
