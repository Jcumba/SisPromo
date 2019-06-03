
package dao;

import Interfaces.AsignacionI;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.AsignacionM;


public class ImplAsignacionD extends Dao implements AsignacionI{

    @Override
    public void guardarAsignacion(AsignacionM asigancion) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO PERSONA_AULA (AULA_CODAUL,PERSONA_CODPER) VALUES (?,?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, asigancion.getAULA_CODAUL());
            ps.setString(2, asigancion.getPERSONA_CODPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
            
    }
    
}
