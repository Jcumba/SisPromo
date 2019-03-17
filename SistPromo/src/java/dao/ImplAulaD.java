
package dao;

import Interfaces.AulaI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
import modelo.AulaM;


public class ImplAulaD  extends Dao implements AulaI{

    @Override
    public void guardar(AulaM aula) throws Exception {
        try {
            this.conectar();
            String sql="INSERT INTO AULA (NUMAUL,FORAUL,ESTAUL,EXAMEN_CODEXA) VALUES (?,?,?,?)";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            ps.setString(1, aula.getNUMAUL());
            ps.setString(2, aula.getFORAUL());
            ps.setString(3, "A");
            ps.setString(4, aula.getEXAMEN_CODEXA());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<AulaM> listarAula() throws Exception {
        List<AulaM> listarAula;
        ResultSet rs;
        try {  
            this.conectar();
            String sql="SELECT * FROM AULA";
            PreparedStatement ps=this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarAula = new ArrayList();
            while(rs.next()) {
                AulaM aula = new AulaM();
                aula.setCODAUL(rs.getString("CODAUL"));
                aula.setNUMAUL(rs.getString("NUMAUL"));
                aula.setFORAUL(rs.getString("FORAUL"));
                listarAula.add(aula);
            }
            
        } catch (SQLException e) {
            throw e;
            
        }finally{
            this.cerrar();
        }
        return listarAula;
    }
    
}