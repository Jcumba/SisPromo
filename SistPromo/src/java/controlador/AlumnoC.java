package controlador;

import dao.AlumnoD;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.AlumnoM;
import modelo.CarreraM;
import org.primefaces.model.chart.PieChartModel;

@Named(value = "alumnoC")
@SessionScoped
public class AlumnoC implements Serializable {

    private AlumnoM alumno = new AlumnoM();

    CarreraM carrera = new CarreraM();
    private List<AlumnoM> lstAlumno;
    private List<AlumnoM> lstAlumnosRegistrado;
    private List<AlumnoM> lstTopAlumno;
    private List<AlumnoM> lstConsulta;
    private List<AlumnoM> lstConsultaNotas;
    private List<AlumnoM> lstOrdenMerito;
    private PieChartModel pieModel;
    private AlumnoM selectedAlumno;
    private String dni = null;
    private String Notas = null;
//    Calendar Cal = Calendar.getInstance();
//    String fechaActual = Cal.get(Calendar.YEAR) + "/" + (Cal.get(Calendar.MONTH) + 01) + "/" + Cal.get(Calendar.DATE);

    public void limpiar() {
        alumno = new AlumnoM();
    }

    @PostConstruct
    public void init() {
        try {
            listarAlumno();
            listarAlumnosRegistrados();
            listarTopColegios();
            listarOrdenMerito();
        } catch (Exception e) {
        }

    }

    private void listarAlumno() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstAlumno = dao.listarAlumno();
        } catch (Exception e) {
            throw e;
        }
    }

    public void descargarPdfMerito() throws Exception {
        Reportes rs;
        try {
            rs = new Reportes();
            rs.exportarPDFMerito();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarAlumnosRegistrados() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstAlumnosRegistrado = dao.listarAlumnoRegistrado();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTopColegios() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstTopAlumno = dao.topColegios();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void guardarAlumno() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            alumno.setUBIGEO_CODUBI(dao.leerUbi(alumno.getUBIGEO_CODUBI()));
            alumno.setCODCOL(dao.obtenerCodigoColegio(alumno.getCODCOL()));
            dao.guardarAlumno(alumno);
            dao.guardarAlumnoHistorial(alumno);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado Correctamente", null));
            limpiar();
            listarAlumnosRegistrados();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL AGREGAR", null));
            throw e;
        }
    }

    public void modificarAlumno() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            alumno.setCODCOL(dao.obtenerCodigoColegio(alumno.getCODCOL()));
            dao.modificarAlumno(alumno);
            listarAlumno();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado Correctamente", null));
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL MODIFICAR", null));
            throw e;
        }
    }

    public void eliminarrAlumno() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            dao.eliminarAlumno(alumno);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado Correctamente", null));
            listarAlumno();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR AL ELIMINAR", null));
            throw e;
        }
    }

    public List<String> completeTextUbi(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutoCompleteUbi(query);
    }

    public List<String> completeTextCol(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutocompleteColegio(query);
    }

    public List<String> competeTextDni(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutoCompleteDni(query);
    }

    public List<String> competeTextNotas(String query) throws SQLException, Exception {
        AlumnoD dao = new AlumnoD();
        return dao.queryAutoCompleteNotas(query);
    }

    public void consultar() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstConsulta = dao.consultar(dni);
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void consultarNotas() throws Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstConsultaNotas = dao.consultarNotas(Notas);
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

//    public void cantidadAlumnos() throws SQLException, Exception {
//        AlumnoD dao;
//        try {
//            dao = new AlumnoD();
//            dao.cantidadAlumnos(alumno);
//        } catch (SQLException e) {
//            throw e;
//        }
//    }
//    public void listarGrafica() {
//        AlumnoD dao;
//        List<AlumnoM> list;
//        try {
//            dao = new AlumnoD();
//            list = dao.CantAlumXCar();
//            graficar(list);
//        } catch (Exception e) {
//        } finally {
//        }
//    }
    private void listarOrdenMerito() throws SQLException, Exception {
        AlumnoD dao;
        try {
            dao = new AlumnoD();
            lstOrdenMerito = dao.OrdenMerito();
        } catch (SQLException e) {
            throw e;
        }
    }

    private void graficar(List<AlumnoM> list) {
        pieModel = new PieChartModel();
        for (AlumnoM tran : list) {
            pieModel.set(tran.getTipoCar(), tran.getCaninscrt());
        }
        pieModel.setTitle(" ");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setDiameter(190);

    }

    public AlumnoM getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoM alumno) {
        this.alumno = alumno;
    }

    public List<AlumnoM> getLstAlumno() {
        return lstAlumno;
    }

    public void setLstAlumno(List<AlumnoM> lstAlumno) {
        this.lstAlumno = lstAlumno;
    }

    public List<AlumnoM> getLstTopAlumno() {
        return lstTopAlumno;
    }

    public void setLstTopAlumno(List<AlumnoM> lstTopAlumno) {
        this.lstTopAlumno = lstTopAlumno;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public CarreraM getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraM carrera) {
        this.carrera = carrera;
    }

    public List<AlumnoM> getLstConsulta() {
        return lstConsulta;
    }

    public void setLstConsulta(List<AlumnoM> lstConsulta) {
        this.lstConsulta = lstConsulta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNotas() {
        return Notas;
    }

    public void setNotas(String Notas) {
        this.Notas = Notas;
    }

    public List<AlumnoM> getLstConsultaNotas() {
        return lstConsultaNotas;
    }

    public void setLstConsultaNotas(List<AlumnoM> lstConsultaNotas) {
        this.lstConsultaNotas = lstConsultaNotas;
    }

    public AlumnoM getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(AlumnoM selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    public List<AlumnoM> getLstOrdenMerito() {
        return lstOrdenMerito;
    }

    public void setLstOrdenMerito(List<AlumnoM> lstOrdenMerito) {
        this.lstOrdenMerito = lstOrdenMerito;
    }

    public List<AlumnoM> getLstAlumnosRegistrado() {
        return lstAlumnosRegistrado;
    }

    public void setLstAlumnosRegistrado(List<AlumnoM> lstAlumnosRegistrado) {
        this.lstAlumnosRegistrado = lstAlumnosRegistrado;
    }

}
