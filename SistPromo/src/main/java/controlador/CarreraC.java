package controlador;
import dao.CarreraImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.CarreraM;

@Data
@Named(value = "carreraC")
@SessionScoped
public class CarreraC implements Serializable {

    private List<CarreraM> lstCarrera;
    private List<CarreraM> lstMerito;
    CarreraM carrera = new CarreraM();

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            listarMerito();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        carrera = new CarreraM();
    }

    public void guardarCarrera() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            dao.guardarCarrera(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CORRECTAMENTE", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL AGREGAR", null));
        }
    }

    public void listar() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            lstCarrera = dao.listarCarrera();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void listarMerito() throws Exception {
        CarreraImpl dao;
        try {
            dao = new CarreraImpl();
            lstMerito = dao.listOrdenMerito();
        } catch (Exception e) {
            throw e;
        }
    }

    

    
}
