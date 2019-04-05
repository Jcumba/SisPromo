
package dao;

import Interfaces.CronogramaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CronogramaM;

/**
 *
 * @author Usuario Alumno
 */
public class CronogramaD extends Dao implements CronogramaI{

    @Override
    public void guardar(CronogramaM cronograma) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO CRONOGRAMA_EXAMEN (FECCROEXA,HORCROEXA) VALUES (to_date(?,'dd/mm/yyyy'),?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, cronograma.getFECCROEXA());
            ps.setString(2, cronograma.getHORCROEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<CronogramaM> listarCronograma() throws Exception {
       List<CronogramaM> listarCronograma;
        ResultSet rs;
        try {
            this.conectar();
            String sql="SELECT * FROM CRONOGRAMA_EXAMEN WHERE ROWNUM < 2 ORDER BY CODEXA DESC";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarCronograma = new ArrayList();
            while(rs.next()) {
                CronogramaM cronograma = new CronogramaM();
                cronograma.setCODEXA(rs.getString("CODEXA"));
                cronograma.setFECCROEXA(rs.getString("FECCROEXA"));
                listarCronograma.add(cronograma);
                
            }
            return listarCronograma;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
}


// 