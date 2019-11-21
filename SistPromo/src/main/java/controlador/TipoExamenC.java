package controlador;

import dao.TipoExamenImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.TipoExamenM;

@Data
@Named(value = "tipExamenC")
@SessionScoped
public class TipoExamenC implements Serializable {

    private List<TipoExamenM> lstTipexamen;
    TipoExamenM examen = new TipoExamenM();

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void limpiarTipoExamen() throws  Exception{
        try {
            examen = new TipoExamenM();
        } catch (Exception e) {
        }
    }
    
    public void agregarTipExam() throws Exception {
        TipoExamenImpl dao;
        try {
            dao = new TipoExamenImpl();
            dao.agregarTipoExamen(examen);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarTipoExamen();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));
            throw e;
        }
    }

    private void listar() throws Exception {
        TipoExamenImpl dao;
        try {
            dao = new TipoExamenImpl();
            lstTipexamen = dao.listarTipoExamen();
        } catch (Exception e) {
            throw e;
        }

    }

}
