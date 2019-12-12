package controlador;

import dao.AlumnoImpl;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.AlumnoM;
import modelo.CarreraM;
import org.primefaces.model.chart.PieChartModel;
import servicio.Reporte;

@Named(value = "alumnoC")
@SessionScoped
@Data
public class AlumnoC implements Serializable {

    private AlumnoM alumno = new AlumnoM();
    private String uniqueAlumn;
    CarreraM carrera = new CarreraM();
    private List<AlumnoM> lstAlumno;
    private List<AlumnoM> lstAlumnosRegistrado;
    private List<AlumnoM> lstTopAlumno;
    private List<AlumnoM> lstConsulta;
    private List<AlumnoM> lstConsultaNotas;
    private PieChartModel pieModel;
    private AlumnoM selectedAlumno;
    private String dni = null;
    private String Notas = null;

    public void limpiar() {
        alumno = null;
    }

    @PostConstruct
    public void iniciar() {
        try {
            listarAlunoRegistrados();
            listarAlumno();
        } catch (Exception e) {
        }
    }

    public void guardarAlumno() throws Exception {
        AlumnoImpl dao;
        try {
            dao = new AlumnoImpl();
            this.setUniqueAlumn(dao.buscarDniAlumno(alumno.getDNIPER()));
            if (alumno.getDNIPER().equals(this.uniqueAlumn)) {
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR, ALUMNO YA REGISTRADO", null));
            } else {
                alumno.setUBIGEO_CODUBI(dao.leerUbi(alumno.getUBIGEO_CODUBI()));
                alumno.setCODCOL(dao.obtenerCodigoColegio(alumno.getCODCOL()));
                dao.agregarAlumnoHistorial(alumno);
                dao.agregarAlumno(alumno);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO CORRECTAMENTE", null));
                limpiar();
                listarAlunoRegistrados();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
            throw e;
        }
    }
    
    public void eliminarAlumno() throws Exception{
       AlumnoImpl dao;
        try {
            dao = new AlumnoImpl();
            dao.eliminarAlumno(selectedAlumno);
            listarAlunoRegistrados();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO CORRECTAMENTE", null));
        } catch (Exception e) {
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR", null));
              throw e;
        }
    }

    public void listarAlumno() throws Exception {
        AlumnoImpl dao;
        try {
            dao = new AlumnoImpl();
            lstAlumno = dao.listarAlumno();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarAlunoRegistrados() throws Exception {
        AlumnoImpl dao1;
        try {
            dao1 = new AlumnoImpl();
            lstAlumnosRegistrado = dao1.listarAlumnoRegistrados();
        } catch (Exception e) {
            throw e;
        }
    }

    public void consultar() throws Exception {
        AlumnoImpl dao;
        try {
            dao = new AlumnoImpl();
            lstConsulta = dao.consultar(dni);
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void reporteFicha(String DNIPER) throws Exception {
        Reporte report = new Reporte();
        try {
            if (DNIPER == null) {
                DNIPER = "";
            }
            HashMap parameters = new HashMap();
            parameters.put("DNIPER", DNIPER);
            report.exportarPDFGlobal(parameters, "ConsultaFicha03.jasper", "Ficha.pdf");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "GENERADO", null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", null));
            throw e;
        }
    }
    
     public void consultarNotas() throws Exception {
        AlumnoImpl dao;
        try {
            dao = new AlumnoImpl();
            lstConsultaNotas = dao.consultarNotas(Notas);
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> completeTextUbi(String query) throws SQLException, Exception {
        AlumnoImpl dao = new AlumnoImpl();
        return dao.queryAutoCompleteUbi(query);
    }

    public List<String> completeTextCol(String query) throws SQLException, Exception {
        AlumnoImpl dao = new AlumnoImpl();
        return dao.queryAutocompleteColegio(query);
    }

    public List<String> competeTextDni(String query) throws SQLException, Exception {
        AlumnoImpl dao = new AlumnoImpl();
        return dao.queryAutoCompleteDni(query);
    }

    public List<String> competeTextNotas(String query) throws SQLException, Exception {
        AlumnoImpl dao = new AlumnoImpl();
        return dao.queryAutoCompleteNotas(query);
    }
    
}
