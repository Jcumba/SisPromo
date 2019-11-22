package controlador;

import dao.CronogramaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.CronogramaM;

@Data
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
        CronogramaImpl dao;
        try {
            dao = new CronogramaImpl();
            dao.agregarCronograma(cronograma);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
            listarCronograma();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERRO AL AGREGAR", null));
            throw e;
        }
    }

    public void modificarCronograma() throws Exception {
        CronogramaImpl dao;
        try {
            dao = new CronogramaImpl();
            dao.modificarCronograma(selectedCronograma);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", null));
            listarCronograma();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERRO AL MODIFICAR", null));
            throw e;
        }
    }

    public void eliminarCronograma() throws Exception {
        CronogramaImpl dao;
        try {
            dao = new CronogramaImpl();
            dao.eliminarCronograma(selectedCronograma);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", null));
            listarCronograma();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERRO AL ELIMINAR", null));
            throw e;
        }
    }

    public void listarCronograma() throws Exception {
        CronogramaImpl dao;
        try {
            dao = new CronogramaImpl();
            lstCronograma = dao.listarCronograma();
        } catch (Exception e) {
            throw e;
        }

    }

}
