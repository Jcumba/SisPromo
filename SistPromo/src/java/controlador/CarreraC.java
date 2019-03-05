package controlador;
import dao.CarreraD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.CarreraM;

@Named(value = "carreraC")
@SessionScoped
public class CarreraC implements Serializable {

    private List<CarreraM> lstCarrera;
    CarreraM carrera = new CarreraM();

 @PostConstruct
 public void iniciar(){
     try {
         listar();
     } catch (Exception e) {
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

}
