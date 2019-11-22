package interfaces;

import java.util.List;
import modelo.CarreraM;

public interface CarreraI {

    List<CarreraM> listarCarrera() throws Exception;

    void guardarCarrera(CarreraM carrera) throws Exception;

    List<CarreraM> listOrdenMerito() throws Exception;
}
