package controlador;

import dao.AlumnoD;
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

    private ColegioM colegio = new ColegioM();
    private ColegioM selectedColegio;
    private List<ColegioM> lstColegio;

//    Calendar Cal = Calendar.getInstance();
//    String fechaActual = Cal.get(Calendar.YEAR) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.DATE);
    @PostConstruct
    public void init() {
        try {
            listarColegio();
        } catch (Exception e) {
        }

    }

    public void limpiar() {
        colegio = new ColegioM();
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

    public void modificarColegio() throws Exception {
        AlumnoD dao1;
        ImplColegioD dao;
        try {
            dao1 = new AlumnoD();
            dao = new ImplColegioD();
            selectedColegio.setUBIGEO_CODUBI(dao1.leerUbi(selectedColegio.getUBIGEO_CODUBI()));
            dao.modificarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }

    public void guardarColegio() throws Exception {
        AlumnoD dao1;
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            dao1 = new AlumnoD();
            colegio.setUBIGEO_CODUBI(dao1.leerUbi(colegio.getUBIGEO_CODUBI()));
            dao.guardarColegio(colegio);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            listarColegio();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
            throw e;
        }
    }

    public void eliminarColegio() throws Exception {
        ImplColegioD dao;
        try {
            dao = new ImplColegioD();
            dao.eliminarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo eliminar"));
            throw e;
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


}
