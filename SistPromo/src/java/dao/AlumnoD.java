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
            String sql = "INSERT INTO PERSONA (NOMPER,APEPER,DNIPER,FECNACPER,CELPER,ESTPER,COLEGIO_CODCOL,CARRERA_CODCAR,UBIGEO_CODUBI)VALUES (?,?,?,(to_date(?,'dd/mm/yyyy')),?,?,?,?,?)";
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

    public List<String> queryAutoCompleteDni(String a) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT DNIPER FROM VW_CONSULTA WHERE DNIPER LIKE ? ";
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

    public List<AlumnoM> consultar(String dni) throws Exception {
        List<AlumnoM> consulta;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM VW_CONSULTA WHERE DNIPER LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            consulta = new ArrayList();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setCODPER(rs.getString("CODPER"));
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setNOMPER(rs.getString("NOMPER"));
                alumno.setAPEPER(rs.getString("APEPER"));
                consulta.add(alumno);
            }
            return consulta;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public List<String> queryAutoCompleteNotas(String a) throws SQLException, Exception {
        this.conectar();
        ResultSet rs;
        List<String> lista;
        try {
            String sql = "SELECT DNIPER FROM MV_LSTNOTAS WHERE DNIPER LIKE ? ";
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

    public List<AlumnoM> consultarNotas(String dni) throws Exception {
        List<AlumnoM> consultar;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM vw_CONSULNOTAS_PUNTAJES WHERE DNIPER LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            consultar = new ArrayList();
            AlumnoM alumno;
            while (rs.next()) {
                alumno = new AlumnoM();
                alumno.setDNIPER(rs.getString("DNIPER"));
                alumno.setNOMPER(rs.getString("NOMPER"));
                alumno.setAPEPER(rs.getString("APEPER"));
                alumno.setRES1(rs.getString("RES1"));
                alumno.setRES2(rs.getString("RES2"));
                alumno.setRES3(rs.getString("RES3"));
                alumno.setRES4(rs.getString("RES4"));
                alumno.setRES5(rs.getString("RES5"));
                alumno.setRES6(rs.getString("RES6"));
                alumno.setRES7(rs.getString("RES7"));
                alumno.setRES8(rs.getString("RES8"));
                alumno.setRES9(rs.getString("RES9"));
                alumno.setRES10(rs.getString("RES10"));
                alumno.setRES11(rs.getString("RES11"));
                alumno.setRES12(rs.getString("RES12"));
                alumno.setRES13(rs.getString("RES13"));
                alumno.setSOL1(rs.getString("SOL1"));
                alumno.setSOL2(rs.getString("SOL2"));
                alumno.setSOL3(rs.getString("SOL3"));
                alumno.setSOL4(rs.getString("SOL4"));
                alumno.setSOL5(rs.getString("SOL5"));
                alumno.setSOL6(rs.getString("SOL6"));
                alumno.setSOL7(rs.getString("SOL7"));
                alumno.setSOL8(rs.getString("SOL8"));
                alumno.setSOL9(rs.getString("SOL9"));
                alumno.setSOL10(rs.getString("SOL10"));
                alumno.setSOL11(rs.getString("SOL11"));
                alumno.setSOL12(rs.getString("SOL12"));
                alumno.setSOL13(rs.getString("SOL13"));
                alumno.setPUNTAJ1(rs.getString("PUNTAJE1"));
                alumno.setPUNTAJ2(rs.getString("PUNTAJE2"));
                alumno.setPUNTAJ3(rs.getString("PUNTAJE3"));
                alumno.setPUNTAJ4(rs.getString("PUNTAJE4"));
                alumno.setPUNTAJ5(rs.getString("PUNTAJE5"));
                alumno.setPUNTAJ6(rs.getString("PUNTAJE6"));
                alumno.setPUNTAJ7(rs.getString("PUNTAJE7"));
                alumno.setPUNTAJ8(rs.getString("PUNTAJE8"));
                alumno.setPUNTAJ9(rs.getString("PUNTAJE9"));
                alumno.setPUNTAJ10(rs.getString("PUNTAJE10"));
                alumno.setPUNTAJ11(rs.getString("PUNTAJE11"));
                alumno.setPUNTAJ12(rs.getString("PUNTAJE12"));
                alumno.setPUNTAJ13(rs.getString("PUNTAJE13"));
                consultar.add(alumno);
            }
            return consultar;
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
            sql = "SELECT * FROM VW_LISALUMCOL";
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
                alumno.setNOMCOL(rs.getString("NOMCOL"));
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

    @Override
    public List<AlumnoM> CantAlumXCar() throws Exception {
        List<AlumnoM> listaCantAlumXCar;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM MV_ALUM_CARRERA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaCantAlumXCar = new ArrayList();
            AlumnoM emp;
            while (rs.next()) {
                emp = new AlumnoM();
                emp.setTipoCar(rs.getString("CARRERAS"));
                emp.setCaninscrt(rs.getInt("TOTAL"));
                listaCantAlumXCar.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listaCantAlumXCar;
    }

 
    @Override
    public List<AlumnoM> OrdenMerito() throws Exception {
        List<AlumnoM> listarMerito;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM VW_ORDEN_MERITO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarMerito = new ArrayList();
            AlumnoM merito;
            while (rs.next()) {
                merito = new AlumnoM();
                merito.setALUMMERIT(rs.getString("ALUMNO"));
                merito.setCANTMERIT(rs.getString("CANTIDAD"));
                merito.setPUNTJMERIT(rs.getString("PUNTAJE"));
                listarMerito.add(merito);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listarMerito;
    }

}
