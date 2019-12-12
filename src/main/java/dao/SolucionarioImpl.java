package dao;

import interfaces.SolucionarioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import modelo.SolucionarioM;

public class SolucionarioImpl extends Dao implements SolucionarioI {

    @Override
    public void agregarSolucionario(SolucionarioM solucion) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO SOLUCIONARIO(SOL1,SOL2,SOL3,SOL4,SOL5,SOL6,"
                    + "SOL7,SOL8,SOL9,SOL10,SOL11,SOL12,SOL13,SOL14,SOL15,SOL16,SOL17,SOL18,SOL19,"
                    + "SOL20,SOL21,SOL22,SOL23,SOL24,SOL25,SOL26,SOL27,SOL28,SOL29,SOL30,SOL31,SOL32,"
                    + "SOL33,SOL34,SOL35,SOL36,SOL37,SOL38,SOL39,SOL40,TIPO_EXAMEN_CODTIPEXA,MODEXA,ESTSOL,NUMPRE)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, solucion.getSOL1());
            ps.setString(2, solucion.getSOL2());
            ps.setString(3, solucion.getSOL3());
            ps.setString(4, solucion.getSOL4());
            ps.setString(5, solucion.getSOL5());
            ps.setString(6, solucion.getSOL6());
            ps.setString(7, solucion.getSOL7());
            ps.setString(8, solucion.getSOL8());
            ps.setString(9, solucion.getSOL9());
            ps.setString(10, solucion.getSOL10());
            ps.setString(11, solucion.getSOL11());
            ps.setString(12, solucion.getSOL12());
            ps.setString(13, solucion.getSOL13());
            ps.setString(14, solucion.getSOL14());
            ps.setString(15, solucion.getSOL15());
            ps.setString(16, solucion.getSOL16());
            ps.setString(17, solucion.getSOL17());
            ps.setString(18, solucion.getSOL18());
            ps.setString(19, solucion.getSOL19());
            ps.setString(20, solucion.getSOL20());
            ps.setString(21, solucion.getSOL21());
            ps.setString(22, solucion.getSOL22());
            ps.setString(23, solucion.getSOL23());
            ps.setString(24, solucion.getSOL24());
            ps.setString(25, solucion.getSOL25());
            ps.setString(26, solucion.getSOL26());
            ps.setString(27, solucion.getSOL27());
            ps.setString(28, solucion.getSOL28());
            ps.setString(29, solucion.getSOL29());
            ps.setString(30, solucion.getSOL30());
            ps.setString(31, solucion.getSOL31());
            ps.setString(32, solucion.getSOL32());
            ps.setString(33, solucion.getSOL33());
            ps.setString(34, solucion.getSOL34());
            ps.setString(35, solucion.getSOL35());
            ps.setString(36, solucion.getSOL36());
            ps.setString(37, solucion.getSOL37());
            ps.setString(38, solucion.getSOL38());
            ps.setString(39, solucion.getSOL39());
            ps.setString(40, solucion.getSOL40());
            ps.setString(41, solucion.getTIPO_EXAMEN_CODTIPEXA());
            ps.setString(42, solucion.getMODALIDAD());
            ps.setString(43, "A");//ESTADO DE EXAMEN
            ps.setString(44, solucion.getNUMPREGUNT());
//            ps.setString(44, solucion.getNOMEXAMEN());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public void agregarSol(SolucionarioM solucion) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO SOLUCIONARIO (SOL1,SOL2,SOL3,SOL4,SOL5,SOL6,"
                    + "SOL7,SOL8,SOL9,SOL10,SOL11,SOL12,SOL13,SOL14,SOL15,SOL16,SOL17,SOL18,SOL19,"
                    + "SOL20,SOL21,SOL22,SOL23,SOL24,SOL25,SOL26,SOL27,SOL28,SOL29,SOL30,SOL31,SOL32,"
                    + "SOL33,SOL34,SOL35,SOL36,SOL37,SOL38,SOL39,SOL40,TIPO_EXAMEN_CODTIPEXA,MODEXA,ESTSOL) "
                    + "values (?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, solucion.getSOL1());
            ps.setString(2, solucion.getSOL2());
            ps.setString(3, solucion.getSOL3());
            ps.setString(4, solucion.getSOL4());
            ps.setString(5, solucion.getSOL5());
            ps.setString(6, solucion.getSOL6());
            ps.setString(7, solucion.getSOL7());
            ps.setString(8, solucion.getSOL8());
            ps.setString(9, solucion.getSOL9());
            ps.setString(10, solucion.getSOL10());
            ps.setString(11, solucion.getSOL11());
            ps.setString(12, solucion.getSOL12());
            ps.setString(13, solucion.getSOL13());
            ps.setString(14, solucion.getSOL14());
            ps.setString(15, solucion.getSOL15());
            ps.setString(16, solucion.getSOL16());
            ps.setString(17, solucion.getSOL17());
            ps.setString(18, solucion.getSOL18());
            ps.setString(19, solucion.getSOL19());
            ps.setString(20, solucion.getSOL20());
            ps.setString(21, solucion.getSOL21());
            ps.setString(22, solucion.getSOL22());
            ps.setString(23, solucion.getSOL23());
            ps.setString(24, solucion.getSOL24());
            ps.setString(25, solucion.getSOL25());
            ps.setString(26, solucion.getSOL26());
            ps.setString(27, solucion.getSOL27());
            ps.setString(28, solucion.getSOL28());
            ps.setString(29, solucion.getSOL29());
            ps.setString(30, solucion.getSOL30());
            ps.setString(31, solucion.getSOL31());
            ps.setString(32, solucion.getSOL32());
            ps.setString(33, solucion.getSOL33());
            ps.setString(34, solucion.getSOL34());
            ps.setString(35, solucion.getSOL35());
            ps.setString(36, solucion.getSOL36());
            ps.setString(37, solucion.getSOL37());
            ps.setString(38, solucion.getSOL38());
            ps.setString(39, solucion.getSOL39());
            ps.setString(40, solucion.getSOL40());
            ps.setString(41, solucion.getTIPO_EXAMEN_CODTIPEXA());
            ps.setString(42, solucion.getMODALIDAD());
            ps.setString(43, "A");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarSolucionario(SolucionarioM solucion) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE SOLUCIONARIO SET TIPO_EXAMEN_CODTIPEXA=?,MODEXA=?,SOL1=?,SOL2=?,SOL3=?,SOL4=?,SOL5=?,SOL6=?,"
                    + "SOL7=?,SOL8=?,SOL9=?,SOL10=?,SOL11=?,SOL12=?,SOL13=?,SOL14=?,SOL15=?,SOL16=?,SOL17=?,SOL18=?,SOL19=?,"
                    + "SOL20=?,SOL21=?,SOL22=?,SOL23=?,SOL24=?,SOL25=?,SOL26=?,SOL27=?,SOL28=?,SOL29=?,SOL30=?,SOL31=?,SOL32=?,"
                    + "SOL33=?,SOL34=?,SOL35=?,SOL36=?,SOL37=?,SOL38=?,SOL39=?,SOL40=? WHERE CODSOL=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, solucion.getSOL1());
            ps.setString(2, solucion.getSOL2());
            ps.setString(3, solucion.getSOL3());
            ps.setString(4, solucion.getSOL4());
            ps.setString(5, solucion.getSOL5());
            ps.setString(6, solucion.getSOL6());
            ps.setString(7, solucion.getSOL7());
            ps.setString(8, solucion.getSOL8());
            ps.setString(9, solucion.getSOL9());
            ps.setString(10, solucion.getSOL10());
            ps.setString(11, solucion.getSOL11());
            ps.setString(12, solucion.getSOL12());
            ps.setString(13, solucion.getSOL13());
            ps.setString(14, solucion.getSOL14());
            ps.setString(15, solucion.getSOL15());
            ps.setString(16, solucion.getSOL16());
            ps.setString(17, solucion.getSOL17());
            ps.setString(18, solucion.getSOL18());
            ps.setString(19, solucion.getSOL19());
            ps.setString(20, solucion.getSOL20());
            ps.setString(21, solucion.getSOL21());
            ps.setString(22, solucion.getSOL22());
            ps.setString(23, solucion.getSOL23());
            ps.setString(24, solucion.getSOL24());
            ps.setString(25, solucion.getSOL25());
            ps.setString(26, solucion.getSOL26());
            ps.setString(27, solucion.getSOL27());
            ps.setString(28, solucion.getSOL28());
            ps.setString(29, solucion.getSOL29());
            ps.setString(30, solucion.getSOL30());
            ps.setString(31, solucion.getSOL31());
            ps.setString(32, solucion.getSOL32());
            ps.setString(33, solucion.getSOL33());
            ps.setString(34, solucion.getSOL34());
            ps.setString(35, solucion.getSOL35());
            ps.setString(36, solucion.getSOL36());
            ps.setString(37, solucion.getSOL37());
            ps.setString(38, solucion.getSOL38());
            ps.setString(39, solucion.getSOL39());
            ps.setString(40, solucion.getSOL40());
            ps.setString(41, solucion.getMODALIDAD());
            ps.setString(42, solucion.getNOMTIPEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminarSolucionario(SolucionarioM solucion) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SolucionarioM> listarSolucionario() throws Exception {
        List<SolucionarioM> listarfecexa;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM VW_SOLUCIONARIO";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarfecexa = new ArrayList();
            SolucionarioM solucion;
            while (rs.next()) {
                solucion = new SolucionarioM();
                solucion.setCODSOL(rs.getString("CODSOL"));
                solucion.setSOL1(rs.getString("SOL1"));
                solucion.setSOL2(rs.getString("SOL2"));
                solucion.setSOL3(rs.getString("SOL3"));
                solucion.setSOL4(rs.getString("SOL4"));
                solucion.setSOL5(rs.getString("SOL5"));
                solucion.setSOL6(rs.getString("SOL6"));
                solucion.setSOL7(rs.getString("SOL7"));
                solucion.setSOL8(rs.getString("SOL8"));
                solucion.setSOL9(rs.getString("SOL9"));
                solucion.setSOL10(rs.getString("SOL10"));
                solucion.setSOL11(rs.getString("SOL11"));
                solucion.setSOL12(rs.getString("SOL12"));
                solucion.setSOL13(rs.getString("SOL13"));
                solucion.setSOL14(rs.getString("SOL14"));
                solucion.setSOL15(rs.getString("SOL15"));
                solucion.setSOL16(rs.getString("SOL16"));
                solucion.setSOL17(rs.getString("SOL17"));
                solucion.setSOL18(rs.getString("SOL18"));
                solucion.setSOL19(rs.getString("SOL19"));
                solucion.setSOL20(rs.getString("SOL20"));
                solucion.setSOL21(rs.getString("SOL21"));
                solucion.setSOL22(rs.getString("SOL22"));
                solucion.setSOL23(rs.getString("SOL23"));
                solucion.setSOL24(rs.getString("SOL24"));
                solucion.setSOL25(rs.getString("SOL25"));
                solucion.setSOL26(rs.getString("SOL26"));
                solucion.setSOL27(rs.getString("SOL27"));
                solucion.setSOL28(rs.getString("SOL28"));
                solucion.setSOL29(rs.getString("SOL29"));
                solucion.setSOL30(rs.getString("SOL30"));
                solucion.setSOL31(rs.getString("SOL31"));
                solucion.setSOL32(rs.getString("SOL32"));
                solucion.setSOL33(rs.getString("SOL33"));
                solucion.setSOL34(rs.getString("SOL34"));
                solucion.setSOL35(rs.getString("SOL35"));
                solucion.setSOL36(rs.getString("SOL36"));
                solucion.setSOL37(rs.getString("SOL37"));
                solucion.setSOL38(rs.getString("SOL38"));
                solucion.setSOL39(rs.getString("SOL39"));
                solucion.setSOL40(rs.getString("SOL40"));
                solucion.setMODALIDAD(rs.getString("MODEXA"));
                solucion.setNOMTIPEXA(rs.getString("NOMTIPEXA"));
                listarfecexa.add(solucion);
            }
            return listarfecexa;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<SolucionarioM> listarFecExam() throws Exception {
        List<SolucionarioM> listarSolucion;
        ResultSet rs;
        try {
            this.conectar();
            String sql;
            sql = "SELECT * FROM VW_CONSLTFECHAS_EXAMEN";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarSolucion = new ArrayList();
            SolucionarioM examen;
            while (rs.next()) {
                examen = new SolucionarioM();
                examen.setNOMEXAMEN(rs.getString("NOMEXA"));
                examen.setMODALIDAD(rs.getString("MODEXA"));
                examen.setFECHA(rs.getString("FECHA"));
                examen.setHORA(rs.getString("HORCROEXA"));
                examen.setNUMPREGUNT(rs.getString("NUMPRE"));
                examen.setSOL1(rs.getString("SOL1"));
                examen.setSOL2(rs.getString("SOL2"));
                examen.setSOL3(rs.getString("SOL3"));
                examen.setSOL4(rs.getString("SOL4"));
                examen.setSOL5(rs.getString("SOL5"));
                examen.setSOL6(rs.getString("SOL6"));
                examen.setSOL7(rs.getString("SOL7"));
                examen.setSOL8(rs.getString("SOL8"));
                examen.setSOL9(rs.getString("SOL9"));
                examen.setSOL10(rs.getString("SOL10"));
                examen.setSOL11(rs.getString("SOL11"));
                examen.setSOL12(rs.getString("SOL12"));
                examen.setSOL13(rs.getString("SOL13"));
                examen.setSOL14(rs.getString("SOL14"));
                examen.setSOL15(rs.getString("SOL15"));
                examen.setSOL16(rs.getString("SOL16"));
                examen.setSOL17(rs.getString("SOL17"));
                examen.setSOL18(rs.getString("SOL18"));
                examen.setSOL19(rs.getString("SOL19"));
                examen.setSOL20(rs.getString("SOL20"));
                examen.setSOL21(rs.getString("SOL21"));
                examen.setSOL22(rs.getString("SOL22"));
                examen.setSOL23(rs.getString("SOL23"));
                examen.setSOL24(rs.getString("SOL24"));
                examen.setSOL25(rs.getString("SOL25"));
                examen.setSOL26(rs.getString("SOL26"));
                examen.setSOL27(rs.getString("SOL27"));
                examen.setSOL28(rs.getString("SOL28"));
                examen.setSOL29(rs.getString("SOL29"));
                examen.setSOL30(rs.getString("SOL30"));
                examen.setSOL31(rs.getString("SOL31"));
                examen.setSOL32(rs.getString("SOL32"));
                examen.setSOL33(rs.getString("SOL33"));
                examen.setSOL34(rs.getString("SOL34"));
                examen.setSOL35(rs.getString("SOL35"));
                examen.setSOL36(rs.getString("SOL36"));
                examen.setSOL37(rs.getString("SOL37"));
                examen.setSOL38(rs.getString("SOL38"));
                examen.setSOL39(rs.getString("SOL39"));
                examen.setSOL40(rs.getString("SOL40"));
                listarSolucion.add(examen);
            }
            return listarSolucion;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }

    }
}
