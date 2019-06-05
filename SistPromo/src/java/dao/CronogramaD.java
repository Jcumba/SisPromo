package dao;

import Interfaces.CronogramaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.Format;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.CronogramaM;

public class CronogramaD extends Dao implements CronogramaI {

//    Format formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void guardar(CronogramaM cronograma) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO CRONOGRAMA_EXAMEN (FECCROEXA,HORCROEXA,SOLUCIONARIO_CODSOL,ESTCRO) VALUES (TO_DATE(?,'DD/MM/YYYY'),?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cronograma.getFECCROEXA());
            ps.setString(2, cronograma.getHORCROEXA());
            ps.setString(3, cronograma.getSOLUCIONARIO_CODSOL());
            ps.setString(4, "A");
//            ps.setString(5, cronograma.getTIPEXA());
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
            String sql = "SELECT * FROM VW_CRONOGRAMA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarCronograma = new ArrayList();
            while (rs.next()) {
                CronogramaM cronograma = new CronogramaM();
                cronograma.setCODEXA(rs.getString("CODEXA"));
                cronograma.setFECCROEXA(rs.getString("FECCROEXA"));
                cronograma.setHORCROEXA(rs.getString("HORCROEXA"));
                cronograma.setTIPEXA(rs.getString("TIPEXA")); 
//                cronograma.setTIPEXA(rs.getString("TIPEXA"));
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


// 
