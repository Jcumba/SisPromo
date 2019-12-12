package controlador;

import dao.CarreraImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.CarreraM;
import servicio.Reporte;

@Data
@Named(value = "carreraC")
@SessionScoped
public class CarreraC implements Serializable {

    private List<CarreraM> lstCarrera;
    private List<CarreraM> lstMerito;
    private CarreraM selectedCarrera;
    CarreraM carrera = new CarreraM();

    @PostConstruct
    public void iniciar() {
        try {
            listarCarrera();
            listarMerito();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        carrera = new CarreraM();
    }

    public void agregarCarrera() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            dao.agregarCarrera(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CORRECTAMENTE", null));
            limpiar();
            listarCarrera();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL AGREGAR", null));
        }
    }

    public void modificarCarrera() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            dao.modificarCarrera(selectedCarrera);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO CORRECTAMENTE", null));
            listarCarrera();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL MODIFICAR", null));
            throw e;
        }
    }

    public void eliminarCarrera() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            dao.eliminarrCarrera(selectedCarrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO CORRECTAMENTE", null));
            limpiar();
            listarCarrera();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL ELIMINAR", null));
            throw e;
        }
    }

    public void listarCarrera() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            lstCarrera = dao.listarCarrera();
        } catch (Exception e) {
            throw e;
        }
    }

    private void listarMerito() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            lstMerito = dao.listOrdenMerito();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
     public void reporteMerito() throws Exception {
        Reporte report = new Reporte();
        try {
            HashMap parameters = new HashMap();
            report.exportarPDFMerito(parameters, "ReporteMerito.jasper", "OrdenMerito.pdf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "GENERADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", null));
            throw e;
        }
    }

}
