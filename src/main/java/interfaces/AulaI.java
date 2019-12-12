package interfaces;

import java.util.List;
import modelo.AulaM;

public interface AulaI {

    void guardar(AulaM aula) throws Exception;

    void modificar(AulaM aula) throws Exception;

    void eliminar(AulaM aula) throws Exception;

    List<AulaM> listarAula() throws Exception;

    List<AulaM> listarCantxAula() throws Exception;
}
