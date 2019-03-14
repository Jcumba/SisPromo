package dao;

import Interfaces.AlumnoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.AlumnoM;

public class AlumnoD extends Dao implements AlumnoI {

    @Override
    public void guardarAlumno(AlumnoM alumno) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,DNIPER,CELPER,ESTPER,COLEGIO_CODCOL,CARRERA_CODCAR,UBIGEO_CODUBI)VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, alumno.getNOMPER());
            ps.setString(2, alumno.getAPEPER());
            ps.setString(3, alumno.getDNIPER());
            ps.setString(4, alumno.getCELPER());
            ps.setString(5, "A"); //ESTADO DE PERSONA
            ps.setString(6, alumno.getCODCOL()); //COLEGIO
            ps.setString(7, alumno.getCARRERA_CODCAR()); //CARRERA
            ps.setString(8, alumno.getUBIGEO_CODUBI()); //UBIGEO
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public List<String> queryAutoCompleteUbi(String a) throws SQLException, ClassNotFoundException, Exception {
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

    public String leerUbi(String a) throws Exception {
        this.conectar();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE (DEPUBI || ', '|| PROUBI || ', '|| DISUBI) = ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public String obtenerCodigoColegio(String Colegio) throws Exception {
        this.conectar();
        ResultSet rs;
        try {
            String sql = "SELECT CODCOL FROM COLEGIO WHERE NOMCOL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Colegio);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODCOL");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> queryAutocompleteColegio(String a) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT NOMCOL FROM COLEGIO WHERE NOMCOL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("NOMCOL"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<AlumnoM> listarAlumno() throws Exception {
        List<AlumnoM> listarAlumno;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "select * FROM MV_ALUMNOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarAlumno = new ArrayList();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setNOMPER(rs.getString("NOMPER"));
                alumno.setAPEPER(rs.getString("APEPER"));
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setCELPER(rs.getString("CELPER"));
                listarAlumno.add(alumno);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarAlumno;
    }

    @Override
    public List<AlumnoM> topColegios() throws Exception {
        List<AlumnoM> listaTop;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM MV_CANT_POSTULANTE";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaTop = new ArrayList();
            AlumnoM emp;
            while (rs.next()) {
                emp = new AlumnoM();
                emp.setNomCol(rs.getString("COLEGIOS"));
                emp.setCantCol(rs.getString("SISTEMAS"));
                listaTop.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaTop;
    }

    @Override
    public void cantidadAlumnos(AlumnoM alumno) throws Exception {
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT COUNT(CODPER) AS ALUMNOS,PERSONA.TIPPER AS TIPO_ALUMNO\n"
                    + "    FROM PERSONA\n"
                    + "    WHERE PERSONA.TIPPER ='A'\n"
                    + "    group by PERSONA.TIPPER";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            alumno.setALUMNOS(rs.getString("ALUMNOS"));
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
