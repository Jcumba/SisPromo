package controlador;

import dao.SolucionarioImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import lombok.Data;
import modelo.SolucionarioM;
//import modelo.TipExamM;

@Data
@Named(value = "solucionarioC")
@SessionScoped
public class SolucionarioC implements Serializable {

    private SolucionarioM solucion = new SolucionarioM();
    private SolucionarioM selectedSolucionario;
    private List<SolucionarioM> lstSolucionario;
    private List<SolucionarioM> lstExamenAsig;
//    TipExamM tipexam = new TipExamM();

    @PostConstruct
    public void iniciar(){
        try {
            listarSolucionario();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        try {
            solucion = new SolucionarioM();
        } catch (Exception e) {
        }
    }

    public void agregarSolucionario() throws Exception {
        SolucionarioImpl dao;
        try {
            dao = new SolucionarioImpl();
            dao.agregarSol(solucion);
            limpiar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", null));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
             throw e;
        }
    }
 

    private void listarSolucionario() throws Exception {
        SolucionarioImpl dao;
        try {
            dao = new SolucionarioImpl();
            lstSolucionario = dao.listarSolucionario();
        } catch (Exception e) {
            throw e;
        }
    }

    private void listarFecExamen() throws Exception {
        SolucionarioImpl dao;
        try {
            dao = new SolucionarioImpl();
            lstExamenAsig = dao.listarFecExam();
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void modificarSolucionario() throws Exception {
        SolucionarioImpl dao;
        try {
            dao = new SolucionarioImpl();
            dao.modificarSolucionario(selectedSolucionario);
            listarSolucionario();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO CORRECTAMENTE", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO AL MODIFICAR", null));
            throw e;
        }

    }

}
