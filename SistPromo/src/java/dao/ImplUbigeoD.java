/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.UbigeoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.UbigeoM;

/**
 *
 * @author Usuario Alumno
 */
public class ImplUbigeoD extends Dao implements UbigeoI {

    @Override
    public void guardarUbigeo(UbigeoM ubigeo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarUbigeo(UbigeoM ubigeo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarUbigeo(UbigeoM ubigeo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UbigeoM> listarUbigeo() throws Exception {
        List<UbigeoM> listarUbigeo;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM UBIGEO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarUbigeo = new ArrayList();
            UbigeoM ubigeo;
            while (rs.next()) {
                ubigeo = new UbigeoM();
                ubigeo.setCODUBI(rs.getString("CODUBI"));
                ubigeo.setDEPUBI(rs.getString("DEPUBI"));
                ubigeo.setPROVUBI(rs.getString("PROUBI"));
                ubigeo.setDISUBI(rs.getString("DISUBI"));
                listarUbigeo.add(ubigeo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarUbigeo;
    }
    
    
      public List<String> queryAutoCompleteUbic(String a) throws SQLException, ClassNotFoundException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        String sql;
        try {
            if (a == null || "".equals(a)) {
                sql = "SELECT  CODUBI,(DEPUBI || ', '|| PROUBI || ', '|| DISUBI) As UBIGEO FROM UBIGEO WHERE PROUBI LIKE ?";
                a = "CAÑETE";
            } else {
                sql = "SELECT CODUBI,(DEPUBI || ', '|| PROUBI || ', '|| DISUBI) AS UBIGEO FROM UBIGEO WHERE DISUBI like UPPER(?)";
            }
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("UBIGEO"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    } 


}
