package interfaces;

import java.util.List;
import modelo.TipoExamenM;

public interface TipoExamenI {

    void agregarTipoExamen(TipoExamenM tipexam) throws Exception;

    void modificarTipoExamen(TipoExamenM tipexam) throws Exception;

    void eliminarTipoExamen(TipoExamenM tipexam) throws Exception;

    List<TipoExamenM> listarTipoExamen() throws Exception;
}
