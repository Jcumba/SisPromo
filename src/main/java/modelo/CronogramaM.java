 package modelo;

import java.sql.Date;
import lombok.Data;

@Data
public class CronogramaM {

    private String CODEXA;
    private String FECCROEXA;
    private String HORCROEXA;
    private String NOMTIPEXA,MODEXA,SOLUCIONARIO_CODSOL;
    Date FECINC;
    java.util.Date fechaTemporal;

}
