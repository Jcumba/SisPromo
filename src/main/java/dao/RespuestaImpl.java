/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.RespuestaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RespuestaM;

/**
 *
 * @author PC31
 */
public class RespuestaImpl extends Dao implements RespuestaI {

    @Override
    public void agregarRespuesta(RespuestaM respuesta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRespuesta(RespuestaM respuesta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarRespuesta(RespuestaM respuesta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RespuestaM> listarRespuesta() throws Exception {
        List<RespuestaM> listarRespuesta;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM VW_PUNTAJES_EXAM";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarRespuesta = new ArrayList();
            RespuestaM respuesta;
            while (rs.next()) {
                respuesta = new RespuestaM();
                respuesta.setNOMPER(rs.getString("NOMPER"));
                respuesta.setAPEPER(rs.getString("APEPER"));
                respuesta.setDNIPER(rs.getString("DNIPER"));
                respuesta.setP1(rs.getString("P1"));
                respuesta.setSOL1(rs.getString("SOL1"));
                respuesta.setP2(rs.getString("P2"));
                respuesta.setSOL2(rs.getString("SOL2"));
                respuesta.setP3(rs.getString("P3"));
                respuesta.setSOL3(rs.getString("SOL3"));
                respuesta.setP4(rs.getString("P4"));
                respuesta.setSOL4(rs.getString("SOL4"));
                respuesta.setP5(rs.getString("P5"));
                respuesta.setSOL5(rs.getString("SOL5"));
                respuesta.setP6(rs.getString("P6"));
                respuesta.setSOL6(rs.getString("SOL6"));
                respuesta.setP7(rs.getString("P7"));
                respuesta.setSOL7(rs.getString("SOL7"));
                respuesta.setP8(rs.getString("P8"));
                respuesta.setSOL8(rs.getString("SOL8"));
                respuesta.setP9(rs.getString("P9"));
                respuesta.setSOL9(rs.getString("SOL9"));
                respuesta.setP10(rs.getString("P10"));
                respuesta.setSOL10(rs.getString("SOL10"));
                respuesta.setP11(rs.getString("P11"));
                respuesta.setSOL11(rs.getString("SOL11"));
                respuesta.setP12(rs.getString("P12"));
                respuesta.setSOL12(rs.getString("SOL12"));
                respuesta.setP13(rs.getString("P13"));
                respuesta.setSOL13(rs.getString("SOL13"));
              
                listarRespuesta.add(respuesta);
            }
            return listarRespuesta;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
