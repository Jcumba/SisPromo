package controlador;

import dao.ImplAulaD;
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
    private AulaM selectedAula;
    private String uniqueAula;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }

    }

    public void limpiar() {
        aula = new AulaM();
    }

    public void guardar() throws Exception {
        ImplAulaD dao;
        try {
            dao = new ImplAulaD();
            this.setUniqueAula(dao.buscarAula(aula.getNUMAUL()));
            if (aula.getNUMAUL().equals(this.uniqueAula)) {
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR, AULA YA REGISTRADO", null));
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
        ImplAulaD dao;
        try {
            dao = new ImplAulaD();
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
        ImplAulaD dao;
        try {
            dao = new ImplAulaD();
            dao.eliminar(selectedAula);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DESACTIVADO CORRECTAMENTE", null));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR", null));
            throw e;
        }
    }

    public void listar() throws Exception {
        ImplAulaD dao;
        try {
            dao = new ImplAulaD();
            lstAula = dao.listarAula();
        } catch (Exception e) {
            throw e;
        }
    }

}
