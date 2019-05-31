/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SolucionarioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.SolucionesM;

/**
 *
 * @author PC
 */
@Named(value = "solucionarioC")
@SessionScoped
public class SolucionarioC implements Serializable {

    private SolucionesM solucion = new SolucionesM();
    private SolucionesM selectedSolucionario;
    private List<SolucionesM> lstSolucionario;

    @PostConstruct
    public void init() {
        try {
            listarSolucionario();
        } catch (Exception e) {
        }

    }

    private void listarSolucionario() throws Exception {
        SolucionarioD dao;
        try {
            dao = new SolucionarioD();
            lstSolucionario = dao.listarSolucionario();
        } catch (Exception e) {
            throw e;
        }
    }

    
      public void guardarSolucionario() throws Exception {
        SolucionarioD dao;
        try {
            dao = new SolucionarioD();
            dao.guardarSolucionario(solucion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarSolucionario();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
//            throw e;
        }
    }
      
      
      public void modificarSolucionario() {
        SolucionarioD dao;
        try {
            dao = new SolucionarioD();
            dao.modificarSolucionario(selectedSolucionario);
            listarSolucionario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
            limpiarSolucionario();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo modificar"));
        }
    }

    public SolucionesM getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionesM solucion) {
        this.solucion = solucion;
    }

    public SolucionesM getSelectedSolucionario() {
        return selectedSolucionario;
    }

    public void setSelectedSolucionario(SolucionesM selectedSolucionario) {
        this.selectedSolucionario = selectedSolucionario;
    }

    public List<SolucionesM> getLstSolucionario() {
        return lstSolucionario;
    }

    public void setLstSolucionario(List<SolucionesM> lstSolucionario) {
        this.lstSolucionario = lstSolucionario;
    }

    private void limpiarSolucionario() {
        solucion = new SolucionesM();
    }

}
