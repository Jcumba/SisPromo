package interfaces;

import java.util.List;
import modelo.CarreraM;

public interface CarreraI {

    void agregarCarrera(CarreraM carrera) throws Exception;
    void modificarCarrera(CarreraM carrera) throws Exception;
    void eliminarrCarrera(CarreraM carrera) throws Exception;
    List<CarreraM> listarCarrera() throws Exception;
    List<CarreraM> listOrdenMerito() throws Exception;

}
