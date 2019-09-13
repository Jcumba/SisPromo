package controlador;
import dao.CarreraD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.CarreraM;

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
        CarreraD dao;
        try {
            dao = new CarreraD();
            dao.guardarCarrera(carrera);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CORRECTAMENTE", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL AGREGAR", null));
        }
    }

    public void listar() throws Exception {
        CarreraD dao;
        try {
            dao = new CarreraD();
            lstCarrera = dao.listarCarrera();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void listarMerito() throws Exception {
        CarreraD dao;
        try {
            dao = new CarreraD();
            lstMerito = dao.listOrdenMerito();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<CarreraM> getLstCarrera() {
        return lstCarrera;
    }

    public void setLstCarrera(List<CarreraM> lstCarrera) {
        this.lstCarrera = lstCarrera;
    }

    public CarreraM getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraM carrera) {
        this.carrera = carrera;
    }

    public List<CarreraM> getLstMerito() {
        return lstMerito;
    }

    public void setLstMerito(List<CarreraM> lstMerito) {
        this.lstMerito = lstMerito;
    }

    
}
