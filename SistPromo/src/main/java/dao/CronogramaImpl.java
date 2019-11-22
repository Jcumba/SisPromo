package dao;

import interfaces.CronogramaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import modelo.CronogramaM;

public class CronogramaImpl extends Dao implements CronogramaI {

    @Override
    public void agregarCronograma(CronogramaM cronograma) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO CRONOGRAMA_EXAMEN (FECCROEXA,HORCROEXA,SOLUCIONARIO_CODSOL,ESTCRO) VALUES (TO_DATE(?,'DD/MM/YYYY'),?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cronograma.getFECCROEXA());
            ps.setString(2, cronograma.getHORCROEXA());
            ps.setString(3, "1");
            ps.setString(4, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarCronograma(CronogramaM cronograma) throws Exception {
         try {
            this.conectar();
            String sql = "UPDATE  CRONOGRAMA_EXAMEN  SET FECCROEXA=?, HORCROEXA=? WHERE CODEXA=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cronograma.getFECCROEXA() );
            ps.setString(2, cronograma.getHORCROEXA());
            ps.setString(3, cronograma.getCODEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    

    @Override
    public void eliminarCronograma(CronogramaM crongrama) throws Exception {
         try {
            this.conectar();
            String sql = "UPDATE  CRONOGRAMA_EXAMEN  SET ESTCRO=? WHERE CODEXA=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, crongrama.getCODEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<CronogramaM> listarCronograma() throws Exception {
        List<CronogramaM> listarCronograma;
        ResultSet rs;
        try {
            this.conectar();
            String sql="SELECT * FROM VW_CRONOGRAMA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarCronograma = new ArrayList();
            while (rs.next()) {
                CronogramaM cronograma = new CronogramaM();
                cronograma.setCODEXA(rs.getString("CODEXA"));
                cronograma.setFECCROEXA(rs.getString("FECCROEXA"));
                cronograma.setHORCROEXA(rs.getString("HORCROEXA"));
                cronograma.setMODEXA(rs.getString("MODEXA"));
                listarCronograma.add(cronograma);
            }
            return listarCronograma;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
