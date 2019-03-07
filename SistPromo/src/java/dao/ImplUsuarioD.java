/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.UsuarioM;

/**
 *
 * @author Alumno
 */
public class ImplUsuarioD extends Dao {

    public UsuarioM startSession(String User, String Pass) throws Exception {
        this.conectar();
        ResultSet rs;
        UsuarioM usuario = null;
        try {
            String sql = "Select NOMPER,APEPER,DNIPER,NIVEL from USUARIO where USUARIO LIKE ? and PASSW LIKE ? and ESTADO LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioM();
                usuario.setNOMPER(rs.getString("NOMPER"));
                usuario.setAPEPER(rs.getString("APEPER"));
                usuario.setDNIPER(rs.getString("DNIPER"));
                usuario.setNIVEL(rs.getString("NIVEL"));
                usuario.setUSU(User);
                usuario.setPAS(Pass);
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        }
    }
}
