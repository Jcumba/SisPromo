package controlador;

import dao.Dao;
import java.io.File;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Reportes extends Dao {
  
    public void exportarPDFCronograma() throws JRException, IOException, Exception {
        this.conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/report/SisPromo.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Cronograma.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    
    public void exportarPDFMerito() throws JRException, IOException, Exception {
        this.conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/report/Merito.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteMeritos.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
