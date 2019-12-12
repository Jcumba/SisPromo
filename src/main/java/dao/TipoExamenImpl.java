package dao;

import interfaces.TipoExamenI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoExamenM;

public class TipoExamenImpl extends Dao implements TipoExamenI {

    @Override
    public void agregarTipoExamen(TipoExamenM tipexam) throws Exception {
        try {
            this.conectar();
            String sql = "Insert into TIPO_EXAMEN(NOMTIPEXA) VALUES (?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipexam.getNOMTIPEXAM());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarTipoExamen(TipoExamenM tipexam) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTipoExamen(TipoExamenM tipexam) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoExamenM> listarTipoExamen() throws Exception {
        List<TipoExamenM> listarTipexamen;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select CODTIPEXA,NOMTIPEXA from TIPO_EXAMEN";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarTipexamen = new ArrayList<>();
            while (rs.next()) {
                TipoExamenM tipexamen = new TipoExamenM();
                tipexamen.setCODTIPEXAM(rs.getString("CODTIPEXA"));
                tipexamen.setNOMTIPEXAM(rs.getString("NOMTIPEXA"));
                listarTipexamen.add(tipexamen);
            }
            return listarTipexamen;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
