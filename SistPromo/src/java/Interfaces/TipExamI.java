/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.TipExamM;

/**
 *
 * @author PC31
 */
public interface TipExamI {
    
     void guardarTipExam(TipExamM tipexam) throws Exception;

    void modificarTipExam(TipExamM tipexam) throws Exception;

    void eliminarTipExam(TipExamM tipexam) throws Exception;


    List<TipExamM> listarTipExam() throws Exception;
}
