package bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.io.IOUtils;

import model.Contrat;
import model.ContratHome;
import model.Etatserveur;
import model.EtatserveurHome;
import model2.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Named
@RequestScoped
public class ContratBean {
	

	private List<Contrat> model;
	
	private ContratHome contratHome = new ContratHome();
	
	
	@SuppressWarnings("unchecked")
	public ContratBean() {
		// TODO Auto-generated constructor stub
		 
		// this.setModel((List<Contrat>) contratHome.findContrat("XF11"));
		
		this.setModel((List<Contrat>) contratHome.GetAll());
	}


	public List<Contrat> getModel() {
		return model;
	}


	public void setModel(List<Contrat> model) {
		this.model = model;
	}
	
public void generatepdf() throws JRException, IOException {
	
	System.out.println("Making pdf...");

    FacesContext fc = FacesContext.getCurrentInstance();
    ExternalContext ec = fc.getExternalContext();
    String tplPath = ec.getRealPath("Contrats.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(tplPath);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String,Object>() );

    String pdfName = "/testReport.pdf";
    String pdfPath = ec.getRealPath(pdfName);
    JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);

    System.out.println("PDF ready!");

    ec.responseReset(); 
    ec.setResponseContentType(ec.getMimeType(pdfPath)); 
    //ec.setResponseContentLength(contentLength); 
    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + pdfName + "\""); 

    InputStream input = new FileInputStream(pdfPath);
    OutputStream output = ec.getResponseOutputStream();
    IOUtils.copy(input, output);

    System.out.println("Sending to browser...");

    fc.responseComplete();  
	
}
	

}
