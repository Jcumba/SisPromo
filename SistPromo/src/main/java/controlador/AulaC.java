package controlador;

import dao.AulaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.AulaM;

@Named(value = "aulaC")
@SessionScoped
@Data
public class AulaC implements Serializable {

    AulaM aula = new AulaM();
    private List<AulaM> lstAula;
    private List<AulaM> lstcantAula;
    private AulaM selectedAula;
    private String uniqueAula;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            listarCantAula();
        } catch (Exception e) {
        }

    }

    public void limpiar() {
        aula = new AulaM();
    }

    public void guardar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            this.setUniqueAula(dao.buscarAula(aula.getNUMAUL()));
            if (aula.getNUMAUL().equals(this.uniqueAula)) {
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error, Aula ya Registrada", "Seleccione otra por favor"));
            } else {
                dao.guardar(aula);
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGARDO CORRECTAMENTE", null));
                listar();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL MODIFICAR", null));
            throw e;
        }
    }

    public void modificarAula() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            dao.modificar(selectedAula);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO CORRECTAMENTE", null));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO AL MODIFICAR", null));
            throw e;
        }

    }

    public void eliminarAula() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            dao.eliminar(selectedAula);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO CORRECTAMENTE", null));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR", null));
            throw e;
        }
    }

    public void listar() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            lstAula = dao.listarAula();
        } catch (Exception e) {
            throw e;
        }
    }

    private void listarCantAula() throws Exception {
        AulaImpl dao;
        try {
            dao = new AulaImpl();
            lstcantAula = dao.listarCantxAula();
        } catch (Exception e) {
            throw e;
        }
    }

}
