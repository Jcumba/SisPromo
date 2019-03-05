/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.ColegioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ColegioM;

/**
 *
 * @author Usuario Alumno
 */
public class ImplColegioD extends Dao implements ColegioI {

    @Override
    public void guardarColegio(ColegioM colegio) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO COLEGIO(NOMCOL,CODREFCOL) VALUES (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, colegio.getNOMCOL());
            ps.setString(2, colegio.getCODREFCOL());
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
            String sql = "UPDATE COLEGIO set NOMCOL=?, CODREFCOL=?  where CODCOL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, colegio.getNOMCOL());
            ps.setString(2, colegio.getCODREFCOL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarColegio(ColegioM colegio) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColegioM> listarColegio() throws Exception {
        List<ColegioM> listarColegio;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM COLEGIO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarColegio = new ArrayList();
            ColegioM colegio;
            while (rs.next()) {
                colegio = new ColegioM();
                colegio.setCODCOL(rs.getString("CODCOL"));
                colegio.setNOMCOL(rs.getString("NOMCOL"));
                colegio.setCODREFCOL(rs.getString("CODREFCOL"));
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
