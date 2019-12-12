
package interfaces;

import java.util.List;
import modelo.CronogramaM;


public interface CronogramaI {
    void agregarCronograma(CronogramaM cronograma) throws Exception;
    void modificarCronograma(CronogramaM cronograma) throws Exception;
    void eliminarCronograma(CronogramaM crongrama) throws Exception;
    List<CronogramaM> listarCronograma() throws Exception;
    
    
}
