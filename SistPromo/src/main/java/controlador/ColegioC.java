package controlador;

import dao.AlumnoImpl;
import dao.ColegioImpl;
import dao.UbigeImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.ColegioM;

@Data
@Named(value = "colegioC")
@SessionScoped
public class ColegioC implements Serializable {

    private ColegioM colegio = new ColegioM();
    private ColegioM selectedColegio;
    private List<ColegioM> lstColegio;

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

    public void guardarColegio() throws Exception {
        AlumnoImpl dao1;
        ColegioImpl dao;
        UbigeImpl ubi;
        
        try {
            dao = new ColegioImpl();
            ubi =new UbigeImpl();
            colegio.setUBIGEO_CODUBI(ubi.obtenerCodigoUbigeo(colegio.getUBIGEO_CODUBI()));
            dao.agregarColegio(colegio);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            listarColegio();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
            throw e;
        }
    }

    public void modificarColegio() throws Exception {
        AlumnoImpl dao1;
        ColegioImpl dao;
        try {
            dao1 = new AlumnoImpl();
            dao = new ColegioImpl();
            selectedColegio.setUBIGEO_CODUBI(dao1.leerUbi(selectedColegio.getUBIGEO_CODUBI()));
            dao.modificarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo modificar"));
            throw e;
        }
    }

    public void eliminarColegio() throws Exception {
        ColegioImpl dao;
        try {
            dao = new ColegioImpl();
            dao.eliminarColegio(selectedColegio);
            listarColegio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", "Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo eliminar"));
            throw e;
        }
    }

    private void listarColegio() throws Exception {
        ColegioImpl dao;
        try {
            dao = new ColegioImpl();
            lstColegio = dao.listarColegio();
        } catch (Exception e) {
            throw e;
        }
    }

}
