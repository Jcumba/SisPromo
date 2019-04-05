package controlador;

import dao.CronogramaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.CronogramaM;

@Named(value = "cronogramaC")
@SessionScoped
public class CronogramaC implements Serializable {

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

    public void guardarCronograma() throws Exception{
        CronogramaD dao;
        try {
            dao = new CronogramaD();
            dao.guardar(cronograma);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            listarCronograma();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERRO AL AGREGAR", null));
                throw e;
        }
    }

    public void descargarPdfCronograma() throws Exception {
        Reportes rs;
        try {
            rs = new Reportes();
            rs.exportarPDFCronograma();
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

}
