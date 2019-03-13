
package Interfaces;

import java.util.List;
import modelo.CronogramaM;


public interface CronogramaI {
    void guardar(CronogramaM cronograma) throws Exception;
    List<CronogramaM> listarCronograma() throws Exception;
    
    
}
