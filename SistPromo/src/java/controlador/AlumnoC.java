package controlador;

import dao.AlumnoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AlumnoM;

@Named(value = "alumnoC")
@SessionScoped
public class AlumnoC implements Serializable {

    AlumnoM alumno = new AlumnoM();

    
    public void limpiar(){
        alumno = new AlumnoM();
    }
    

    public void guardarAlumno() {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            alumno.setUBIGEO_CODUBI(dao.leerUbi(alumno.getUBIGEO_CODUBI()));
            dao.guardarAlumno(alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente",null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR",null));
        }
    }
    
    public List<String> completeTextUbi (String query) throws SQLException, Exception{
        AlumnoD dao = new AlumnoD();
        return dao.queryAutoCompleteUbi(query);
    }
   

 
    
    public AlumnoM getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoM alumno) {
        this.alumno = alumno;
    }
    
}
