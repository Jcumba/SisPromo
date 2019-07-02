//
//package dao;
//
//import Interfaces.Historial_PersonaI;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import modelo.Historial_PersonaM;
//
//
//
//public class Historial_PersonaD  extends Dao  implements Historial_PersonaI{
//
//    @Override
//    public void guardarHstorial_Persona(Historial_PersonaM historialPer) throws Exception {
//        try {
//            this.conectar();
//            String sql="INSERT INTO HISTORIAL_PERSONA (NOMPER,APEPER,DNIPER) VALUES (?,?,?)";
//            PreparedStatement ps=this.getCn().prepareStatement(sql);
//            ps.setString(1, historialPer.getNOMPER());
//            ps.setString(2, historialPer.getAPEPER());
//            ps.setString(3, historialPer.getDNIPER());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw e;
//        } finally{
//            this.cerrar();
//        }
//    }
//
//    @Override
//    public void modificarHistorial_Persona(Historial_PersonaM historialPer) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void eliminarHistorial_Persona(Historial_PersonaM historialPer) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//
//
////    @Override
////    public void guardarHstorial_Persona(Historial_PersonaM historialPer) throws Exception {
////        try {
////            this.conectar();
////            String sql="INSERT INTO HISTORIAL_PERSONA (H_NOMPER,H_APEPER,H_DNIPER) VALUES (?,?,?)";
////            PreparedStatement ps=this.getCn().prepareStatement(sql);
////            ps.setString(1, historialPer.get);
////        } catch (Exception e) {
////        }
////    }
//
//}
