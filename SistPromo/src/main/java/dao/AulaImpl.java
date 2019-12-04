package dao;

import interfaces.AulaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.AulaM;

public class AulaImpl extends Dao implements AulaI {

    @Override
    public void guardar(AulaM aula) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO AULA(NUMAUL,AFORAUL,ESTAUL,EXAMEN_CODEXA) VALUES (?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, aula.getNUMAUL());
            ps.setString(2, aula.getAFORAUL());
            ps.setString(3, "A");
            ps.setString(4, aula.getEXAMEN_CODEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(AulaM aula) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE AULA SET NUMAUL=?,AFORAUL=? WHERE CODAUL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, aula.getNUMAUL());
            ps.setString(2, aula.getAFORAUL());
            ps.setString(3, aula.getCODAUL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(AulaM aula) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE AULA SET ESTAUL=? WHERE CODAUL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, aula.getCODAUL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<AulaM> listarAula() throws Exception {
        List<AulaM> listarAula;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_AULA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarAula = new ArrayList();
            while (rs.next()) {
                AulaM aula = new AulaM();
                aula.setCODAUL(rs.getString("CODAUL"));
                aula.setNUMAUL(rs.getString("NUMAUL"));
                aula.setAFORAUL(rs.getString("AFORAUL"));
                aula.setEXAMEN_CODEXA(rs.getString("FECCROEXA"));
                aula.setHORCROEXA(rs.getString("HORCROEXA"));
                aula.setMODEXA(rs.getString("MODEXA"));
                aula.setTIPEXA(rs.getString("NOMTIPEXA"));
                listarAula.add(aula);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarAula;
    }

    public String buscarAula(String numAula) throws Exception {
        this.conectar();
        try {
            ResultSet rs;
            String sql = "SELECT NUMAUL FROM AULA WHERE  NUMAUL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, numAula);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("NUMAUL");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<AulaM> listarCantxAula() throws Exception {
        List<AulaM> listarCantxAula;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_CANTPOSTULANTE_AULA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarCantxAula = new ArrayList();
            while (rs.next()) {
                AulaM cantaul = new AulaM();
                cantaul.setNUMAUL(rs.getString("NUMAUL"));
                cantaul.setCANTAUL(rs.getString("CANTIDA"));
                listarCantxAula.add(cantaul);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarCantxAula;
    }
}
