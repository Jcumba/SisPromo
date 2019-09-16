package controlador;

import dao.ImplAsignacionD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AsignacionM;

@Named(value = "asignacionC")
@SessionScoped
public class AsignacionC implements Serializable {

    AsignacionM asignacion = new AsignacionM();

    public void limpiar() {
        asignacion = new AsignacionM();
    }

    public void guardar() throws Exception {
        ImplAsignacionD dao;
        try {
            dao = new ImplAsignacionD();
            dao.guardarAsignacion(asignacion);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CORRECTAMENTE", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
            throw e;

        }
    }

    public AsignacionM getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(AsignacionM asignacion) {
        this.asignacion = asignacion;
    }

    private int number;

    public void increment() {
        number++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
