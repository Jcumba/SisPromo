package dao;

import interfaces.AlumnoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AlumnoM;

public class AlumnoImpl extends Dao implements AlumnoI {

    @Override
    public void agregarAlumnoHistorial(AlumnoM alumno) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO HISTORIAL_PERSONA (NOMPER,APEPER,DNIPER,CELPER) VALUES (?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, alumno.getNOMPER());
            ps.setString(2, alumno.getAPEPER());
            ps.setString(3, alumno.getDNIPER());
            ps.setString(4, alumno.getCELPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void agregarAlumno(AlumnoM alumno) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,DNIPER,FECNACPER,CELPER,ESTPER,COLEGIO_CODCOL,CARRERA_CODCAR,UBIGEO_CODUBI)VALUES"
                    + "(?,?,?,(to_date(?,'dd/mm/yyyy')),?,?,?,?,?)";
//            String sql = "{CALL SP_ASIGNACION_DEMO(?,?,?,?,?,?,?,?)}";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, alumno.getNOMPER());
            ps.setString(2, alumno.getAPEPER());
            ps.setString(3, alumno.getDNIPER());
            ps.setString(4, alumno.getFECNACPER());
            ps.setString(5, alumno.getCELPER());
            ps.setString(6, "A"); //ESTADO DE PERSONA
            ps.setString(7, alumno.getCODCOL()); //COLEGIO
            ps.setString(8, alumno.getCARRERA_CODCAR()); //CARRERA
            ps.setString(9, alumno.getUBIGEO_CODUBI()); //UBIGEO
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarAlumno(AlumnoM alumno) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET NOMPER=?, APEPER=?, DNIPER=?,COLEGIO_CODCOL=? WHERE CODPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, alumno.getNOMPER());
            ps.setString(2, alumno.getAPEPER());
            ps.setString(3, alumno.getDNIPER());
            ps.setString(4, alumno.getCODCOL());
            ps.setString(5, alumno.getCODPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarAlumno(AlumnoM alumno) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PERSONA SET ESTPER=? WHERE CODPER=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, alumno.getCODPER());
            ps.executeUpdate();
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
            sql = "SELECT * FROM  VW_BUSCADOR";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarAlumno = new ArrayList();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setCODPER(rs.getString("CODPER"));
                alumno.setNOMPER(rs.getString("NOMPER"));
                alumno.setAPEPER(rs.getString("APEPER"));
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setFECCROEXA(rs.getString("FECCROEXA"));
                alumno.setHORCROEXA(rs.getString("HORCROEXA"));
                alumno.setNUMAUL(rs.getString("NUMAUL"));
                alumno.setMODEXA(rs.getString("MODEXA"));
                alumno.setNOMTIPEXA(rs.getString("TIPO_EXAMEN_CODTIPEXA"));
                listarAlumno.add(alumno);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarAlumno;
    }

    public List<AlumnoM> listarAlumnoRegistrados() throws Exception {
        List<AlumnoM> listarAlumnoRegistrados;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT  * FROM VW_LSTALUMNOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarAlumnoRegistrados = new ArrayList<>();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setCODPER(rs.getString("CODPER"));
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setALUMNO(rs.getString("ALUMNO"));
                alumno.setNOMCOL(rs.getString("NOMCOL"));
                alumno.setDISTRITO(rs.getString("DISTRITO"));
                listarAlumnoRegistrados.add(alumno);
            }
            return listarAlumnoRegistrados;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    // CONSULTAR DNI //
    public List<AlumnoM> consultar(String dni) throws Exception {
        List<AlumnoM> consulta;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_CONSULTAFICHA WHERE DNIPER LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            consulta = new ArrayList();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setCODPER(rs.getString("CODPER"));
                alumno.setNOMPER(rs.getString("NOMPER"));
                alumno.setAPEPER(rs.getString("APEPER"));
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setNUMAUL(rs.getString("NUMAUL"));
                alumno.setFECCROEXA(rs.getString("FECCROEXA"));
                alumno.setHORCROEXA(rs.getString("HORCROEXA"));
                alumno.setNOMTIPEXA(rs.getString("NOMTIPEXA"));
                alumno.setMODEXA(rs.getString("MODEXA"));
                consulta.add(alumno);
            }
            return consulta;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    
    
    
    // DNI ALUMNO
    public List<String> queryAutoCompleteDni(String a) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
                String sql = "SELECT DNIPER FROM VW_CONSULTAFICHA WHERE DNIPER LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("DNIPER"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public String buscarDniAlumno(String dniAlum) throws Exception {
        this.conectar();
        try {
            ResultSet rs;
            String sql = "SELECT DNIPER FROM PERSONA WHERE ESTPER='A' and DNIPER LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, dniAlum);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("DNIPER");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    //COLEGIO
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

    //UBIGEO
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

}
