/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.TipExamI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipExamM;

/**
 *
 * @author PC31
 */
public class ImplTipExamenD extends Dao implements TipExamI {

    @Override
    public void guardarTipExam(TipExamM tipexam) throws Exception {
        try {
            this.conectar();
            String sql = "Insert into TIPO_EXAMEN(NOMTIPEXA) VALUES (?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tipexam.getNOMTIPEXAM());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificarTipExam(TipExamM tipexam) throws Exception {

    }

    @Override
    public void eliminarTipExam(TipExamM tipexam) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipExamM> listarTipExam() throws Exception {
        List<TipExamM> listarTipexamen;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "select * from TIPO_EXAMEN";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listarTipexamen = new ArrayList<>();
            while (rs.next()) {
                TipExamM tipexamen = new TipExamM();
                tipexamen.setCODTIPEXAM(rs.getString("CODTIPEXA"));
                tipexamen.setNOMTIPEXAM(rs.getString("NOMTIPEXA"));
                listarTipexamen.add(tipexamen);
            }
            return listarTipexamen;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
