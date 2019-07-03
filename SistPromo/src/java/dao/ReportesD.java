package dao;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportesD extends Dao {

    public void REPORTE_PDF_SARCH(Map parameters) throws JRException, IOException, Exception {
        conectar();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reporte/ConnecBuscador.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.getCn());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=REPORTE EXAMEN DE CONCURSO.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {

            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();

        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
