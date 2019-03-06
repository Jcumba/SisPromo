
package controlador;

import dao.ImplColegioD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.ColegioM;
import org.primefaces.PrimeFaces;

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
    
    Calendar Cal = Calendar.getInstance();
    
    String fechaActual = Cal.get(Calendar.YEAR) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.DATE);

    @PostConstruct
    public void init() {

        try {
            listarColegio();
        } catch (Exception e) {
        }

    }
    
    public void fechaDev() throws ParseException {
        String fechaHoy = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fechaHoy;
        Date fecha = null;
        fecha = formatoDelTexto.parse(strFecha);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(fecha);
        cal.add(Calendar.DATE, 3);
        System.out.println(formatoDeFecha.format(cal.getTime()));
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

    public void showMessage() throws ParseException {
        String fechaHoy = Cal.get(Calendar.DATE) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.YEAR);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fechaHoy;
        Date fecha = null;
        fecha = formatoDelTexto.parse(strFecha);
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(fecha);
        cal.add(Calendar.DATE, 3);
        System.out.println(formatoDeFecha.format(cal.getTime()));
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Bienvenido!", "Usted se ha registrado correctamente  " + "Fecha de Examen  "+formatoDeFecha.format(cal.getTime()));
        
        PrimeFaces.current().dialog().showMessageDynamic(message);
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
