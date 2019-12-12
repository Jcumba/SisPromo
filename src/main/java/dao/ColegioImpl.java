package dao;

import interfaces.ColegioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ColegioM;

public class ColegioImpl extends Dao implements ColegioI {

    @Override
    public void agregarColegio(ColegioM colegio) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO COLEGIO(NOMCOL,ESTCOL,UBIGEO_CODUBI) VALUES (?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, colegio.getNOMCOL());
            ps.setString(2, "A");
            ps.setString(3, colegio.getUBIGEO_CODUBI());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarColegio(ColegioM colegio) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE COLEGIO set NOMCOL=?,UBIGEO_CODUBI=?  where CODCOL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, colegio.getNOMCOL());
            ps.setString(2, colegio.getUBIGEO_CODUBI());
            ps.setString(3, colegio.getCODCOL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarColegio(ColegioM colegio) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE COLEGIO SET ESTCOL=? WHERE  CODCOL=?";
//            String sql = "DELETE FROM COLEGIO WHERE CODCOL LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, colegio.getCODCOL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<ColegioM> listarColegio() throws Exception {
        List<ColegioM> listarColegio;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM VW_COLEGIO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarColegio = new ArrayList();
            ColegioM colegio;
            while (rs.next()) {
                colegio = new ColegioM();
                colegio.setCODCOL(rs.getString("CODCOL"));
                colegio.setNOMCOL(rs.getString("NOMCOL"));
                colegio.setDISTRITO(rs.getString("DISTRITO"));
                listarColegio.add(colegio);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarColegio;
    }

}
