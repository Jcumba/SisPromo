
package interfaces;

import java.util.List;
import modelo.SolucionarioM;


public interface SolucionarioI {
    
     void agregarSolucionario(SolucionarioM solucion) throws Exception;

    //Este método sirve para modificar registros de la tabla CLIENTE de la base de datos FactElect
    void modificarSolucionario(SolucionarioM solucion) throws Exception;

    //Este método sirve para eliminar un cliente de la tabla CLIENTE de la base de datos FactElect
    void eliminarSolucionario(SolucionarioM solucion) throws Exception;

    //Este método sirve para listar los registros de la tabla cliente de la base de datos FactElect
    List<SolucionarioM> listarSolucionario() throws Exception;
    List<SolucionarioM> listarFecExam() throws Exception;

}
