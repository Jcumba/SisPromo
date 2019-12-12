package dao;

import interfaces.CarreraI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CarreraM;

public class CarreraImpl extends Dao implements CarreraI {

    @Override
    public void agregarCarrera(CarreraM carrera) throws Exception {
        try {
            this.conectar();
            String sql = "Insert into CARRERA (NOMCAR,ESTCAR) VALUES (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, carrera.getNOMCAR());
            ps.setString(2, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarCarrera(CarreraM carrera) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE CARRERA SET NOMCAR=? WHERE CODCAR=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, carrera.getNOMCAR());
            ps.setString(2, carrera.getCODCAR());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarrCarrera(CarreraM carrera) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE CARRERA SET ESTCAR=? WHERE CODCAR=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, carrera.getCODCAR());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<CarreraM> listarCarrera() throws Exception {
        List<CarreraM> listarCarrera;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select * from CARRERA where ESTCAR LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarCarrera = new ArrayList<>();
            while (rs.next()) {
                CarreraM carrera = new CarreraM();
                carrera.setCODCAR(rs.getString("CODCAR"));
                carrera.setNOMCAR(rs.getString("NOMCAR"));
                listarCarrera.add(carrera);
            }
            return listarCarrera;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }

    @Override
    public List<CarreraM> listOrdenMerito() throws Exception {
        List<CarreraM> listarMerito;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select * from VW_PUNTJ_APROBATORIO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarMerito = new ArrayList<>();
            while (rs.next()) {
                CarreraM merito = new CarreraM();
                merito.setNOMTIPEXA(rs.getString("NOMTIPEXA"));
                merito.setMODEXA(rs.getString("MODEXA"));
                merito.setNOMPER(rs.getString("NOMPER"));
                merito.setALUMNO(rs.getString("ALUMNO"));
                merito.setCANTIDAD(rs.getString("CANTIDAD"));
                merito.setPUNTAJE(rs.getString("PUNTAJE"));
                listarMerito.add(merito);
            }
            return listarMerito;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
