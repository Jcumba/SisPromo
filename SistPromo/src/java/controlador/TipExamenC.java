/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ImplTipExamenD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.TipExamM;

/**
 *
 * @author PC31
 */
@Named(value = "tipExamenC")
@SessionScoped
public class TipExamenC implements Serializable {

    private List<TipExamM> lstTipexamen;
    TipExamM examen = new TipExamM();

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void guardarTipExam() throws Exception {
        ImplTipExamenD dao;
        try {
            dao = new ImplTipExamenD();
            dao.guardarTipExam(examen);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarTipExamen();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
//            throw e;
        }
    }

    public List<TipExamM> getLstTipexamen() {
        return lstTipexamen;
    }

    public void setLstTipexamen(List<TipExamM> lstTipexamen) {
        this.lstTipexamen = lstTipexamen;
    }

    public TipExamM getExamen() {
        return examen;
    }

    public void setExamen(TipExamM examen) {
        this.examen = examen;
    }

    private void listar() throws Exception {
        ImplTipExamenD dao;
        try {
            dao = new ImplTipExamenD();
            lstTipexamen = dao.listarTipExam();
        } catch (Exception e) {
            throw e;
        }

    }

    private void limpiarTipExamen() {
        examen = new TipExamM();
    }

}
