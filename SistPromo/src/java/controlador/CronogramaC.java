package controlador;

import dao.AlumnoD;
import dao.CronogramaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.CronogramaM;

@Named(value = "cronogramaC")
@SessionScoped
public class CronogramaC implements Serializable {
    private String DNIPER;
    CronogramaM cronograma = new CronogramaM();
    private List<CronogramaM> lstCronograma;
    private CronogramaM selectedCronograma;

    @PostConstruct
    public void iniciar() {
        try {
            listarCronograma();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        cronograma = new CronogramaM();
    }

    public void guardarCronograma() throws Exception {
        CronogramaD dao;
        try {
            dao = new CronogramaD();
//            cronograma.setFECINC(new java.sql.Date(cronograma.getFechaTemporal().getTime()));
            dao.guardar(cronograma);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            listarCronograma();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERRO AL AGREGAR", null));
            throw e;
        }
    }

//    public void descargarPdfCronograma() throws Exception {
//        Reportes rs;
//        try {
//            rs = new Reportes();
//            rs.exportarPDFCronograma();
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    
//    DESCARGAR REPORTE_PDF_FECHADEEXAMEN
    public void REPORTE_PDF_FECHADEEXAMEN(String DNIPER) throws Exception {
        AlumnoD dao = new AlumnoD();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("DNIPER",DNIPER); //Insertamos un parametro
            dao.REPORTE_PDF_FECHADEEXAMEN(parameters);
//            reportAlu.REPORTE_PDF_ALUMNO(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void listarCronograma() throws Exception {
        CronogramaD dao;
        try {
            dao = new CronogramaD();
            lstCronograma = dao.listarCronograma();
        } catch (Exception e) {
            throw e;
        }

    }

    public CronogramaM getCronograma() {
        return cronograma;
    }

    public void setCronograma(CronogramaM cronograma) {
        this.cronograma = cronograma;
    }

    public List<CronogramaM> getLstCronograma() {
        return lstCronograma;
    }

    public void setLstCronograma(List<CronogramaM> lstCronograma) {
        this.lstCronograma = lstCronograma;
    }

    public CronogramaM getSelectedCronograma() {
        return selectedCronograma;
    }

    public void setSelectedCronograma(CronogramaM selectedCronograma) {
        this.selectedCronograma = selectedCronograma;
    }

    public String getDNIPER() {
        return DNIPER;
    }

    public void setDNIPER(String DNIPER) {
        this.DNIPER = DNIPER;
    }

 
}
