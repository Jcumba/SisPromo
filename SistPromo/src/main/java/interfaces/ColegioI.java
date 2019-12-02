
package interfaces;

import java.util.List;
import modelo.ColegioM;


public interface ColegioI {

    void agregarColegio(ColegioM colegio) throws Exception;

    void modificarColegio(ColegioM colegio) throws Exception;

  
    void eliminarColegio(ColegioM colegio) throws Exception;

    List<ColegioM> listarColegio() throws Exception;

}
