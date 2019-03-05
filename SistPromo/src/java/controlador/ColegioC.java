/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ImplColegioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ColegioM;

/**
 *
 * @author Usuario Alumno
 */
@Named(value = "colegioC")
@SessionScoped
public class ColegioC implements Serializable {

    ColegioM colegio = new ColegioM();
    private ColegioM selectedColegio;
    private List<ColegioM> lstColegio;

    @PostConstruct
    public void init() {

        try {
            listarColegio();
        } catch (Exception e) {
        }

    }

    private void listarColegio() throws Exception {
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            lstColegio = dao.listarColegio();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarColegio() {
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            dao.modificarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
            limpiarColegio();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo modificar"));
        }
    }

    public void guardarColegio() {
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            dao.guardarColegio(colegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarColegio();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
        }
    }

    public void eliminarColegio() {
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            dao.eliminarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo eliminar"));
        }
    }

    public ColegioM getColegio() {
        return colegio;
    }

    public void setColegio(ColegioM colegio) {
        this.colegio = colegio;
    }

    public ColegioM getSelectedColegio() {
        return selectedColegio;
    }

    public void setSelectedColegio(ColegioM selectedColegio) {
        this.selectedColegio = selectedColegio;
    }

    public List<ColegioM> getLstColegio() {
        return lstColegio;
    }

    public void setLstColegio(List<ColegioM> lstColegio) {
        this.lstColegio = lstColegio;
    }

    private void limpiarColegio() {
        colegio = new ColegioM();

    }

}
