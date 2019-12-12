/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.UsuarioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.UsuarioM;

/**
 *
 * @author Alumno
 */
public class ImplUsuarioD extends Dao implements UsuarioI {

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

    @Override
    public void guardarUsuario(UsuarioM usuario) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO USUARIO(NOMPER,APEPER,DNIPER,NIVEL,ESTADO,USUARIO,PASSW) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, usuario.getNOMPER());
            ps.setString(2, usuario.getAPEPER());
            ps.setString(3, usuario.getDNIPER());
            ps.setString(4, "2");
            ps.setString(5, "A");
            ps.setString(6, usuario.getUSU());
            ps.setString(7, usuario.getPAS());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarUsuario(UsuarioM usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarUsuario(UsuarioM usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioM> listarUsuario() throws Exception {
        List<UsuarioM> listaUsuario;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM USUARIO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaUsuario = new ArrayList();
            UsuarioM usuario;
            while (rs.next()) {
                usuario = new UsuarioM();
                usuario.setCODUS(rs.getString("CODIGO"));
                usuario.setNOMPER(rs.getString("NOMPER"));
                usuario.setAPEPER(rs.getString("APEPER"));
                usuario.setDNIPER(rs.getString("DNIPER"));
                usuario.setNIVEL(rs.getString("NIVEL"));
                usuario.setESTADO(rs.getString("ESTADO"));
                usuario.setUSU(rs.getString("USUARIO"));
                usuario.setPAS(rs.getString("PASSW"));
                listaUsuario.add(usuario);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaUsuario;
    }

}
