package controlador;

import dao.AlumnoD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AlumnoM;
import modelo.CarreraM;
//import org.primefaces.PrimeFaces;

@Named(value = "alumnoC")
@SessionScoped
public class AlumnoC implements Serializable {

    AlumnoM alumno = new AlumnoM();
    CarreraM carrera = new CarreraM();
    
  
//    Calendar Cal = Calendar.getInstance();

//    String fechaActual = Cal.get(Calendar.YEAR) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.DATE);

    public void limpiar() {
        alumno = new AlumnoM();
    }

    public void guardarAlumno() {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            alumno.setUBIGEO_CODUBI(dao.leerUbi(alumno.getUBIGEO_CODUBI()));
            alumno.setCODCOL(dao.obtenerCodigoColegio(alumno.getCODCOL()));
            dao.guardarAlumno(alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
        }
    }

    public List<String> completeTextUbi(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutoCompleteUbi(query);
    }

//    public void showMessages() throws ParseException {
//        String fechaHoy = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
//        String strFecha = fechaHoy;
//        Date fecha = null;
//        fecha = formatoDelTexto.parse(strFecha);
//        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
//        cal.setTime(fecha);
//        cal.add(Calendar.DATE, 5);
//        System.out.println(formatoDeFecha.format(cal.getTime()));
//
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Bienvenido!", "Usted se ha registrado correctamente  " + "Fecha de Examen  " + formatoDeFecha.format(cal.getTime()) + "  Aula: 1");
//        PrimeFaces.current().dialog().showMessageDynamic(message);
//    }

    public List<String> completeTextCol(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutocompleteColegio(query);
    }

    public AlumnoM getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoM alumno) {
        this.alumno = alumno;
    }



    
}
