
package controlador;

import dao.ImplAulaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AulaM;


@Named(value = "aulaC")
@SessionScoped
public class AulaC implements Serializable {

    AulaM aula = new AulaM();
    private List<AulaM> lstAula;
    
    
    
    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
            
    }
    
    
    
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
    
    
  public void listar() throws Exception{
      ImplAulaD dao;
      try {
          dao = new ImplAulaD();
          lstAula = dao.listarAula();
      } catch (Exception e) {
          throw e;
      }
  }

    public AulaM getAula() {
        return aula;
    }

    public void setAula(AulaM aula) {
        this.aula = aula;
    }

    public List<AulaM> getLstAula() {
        return lstAula;
    }

    public void setLstAula(List<AulaM> lstAula) {
        this.lstAula = lstAula;
    }
    
    
}
