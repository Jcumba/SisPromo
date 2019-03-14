
package controlador;

import dao.ImplAulaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AulaM;


@Named(value = "aulaC")
@SessionScoped
public class AulaC implements Serializable {

    AulaM aula = new AulaM();
    
    
    public void limpiar(){
        aula = new AulaM();
    }
            
    public void guardar(){
        ImplAulaD dao;
        try {
            dao = new ImplAulaD();
            dao.guardar(aula);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGARDO CORRECTAMENTE", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
        }
    }

    public AulaM getAula() {
        return aula;
    }

    public void setAula(AulaM aula) {
        this.aula = aula;
    }
    
}
