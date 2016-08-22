package bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sun.xml.registry.uddi.bindings_v2_2.Contact;

import model.Employee;
import model.EmployeeHome;
import model.Entreprise;
import model.EntrepriseHome;
import model.EquipeHome;
import model.Contrat;
import model.ContratHome;

@Named
@RequestScoped
public class EntrepriseBean {
	

	private List<Entreprise> model;
	private Contrat contrat;
	private ContratHome contratHome=new ContratHome();
	private EntrepriseHome EntrepriseHome = new EntrepriseHome();
	private String etrp;
	private BigDecimal contratMontant;
	private BigDecimal contratPenalite;
	private Date contratddebut;
	private String contratloides;
	private int contratduree;
	Entreprise entreprise;
	public EntrepriseHome getEntrepriseHome() {
		return EntrepriseHome;
	}


	public void setEntrepriseHome(EntrepriseHome entrepriseHome) {
		EntrepriseHome = entrepriseHome;
	}


	public BigDecimal getContratMontant() {
		return contratMontant;
	}


	public void setContratMontant(BigDecimal contratMontant) {
		this.contratMontant = contratMontant;
	}


	public BigDecimal getContratPenalite() {
		return contratPenalite;
	}


	public void setContratPenalite(BigDecimal contratPenalite) {
		this.contratPenalite = contratPenalite;
	}


	public Date getContratddebut() {
		return contratddebut;
	}


	public void setContratddebut(Date contratddebut) {
		this.contratddebut = contratddebut;
	}


	public String getContratloides() {
		return contratloides;
	}


	public void setContratloides(String contratloides) {
		this.contratloides = contratloides;
	}


	public int getContratduree() {
		return contratduree;
	}


	public void setContratduree(int contratduree) {
		this.contratduree = contratduree;
	}


	@SuppressWarnings("unchecked")
	public EntrepriseBean() {
		// TODO Auto-generated constructor stub
		 contrat = new  Contrat();
		 entreprise = new Entreprise();
		 this.setModel((List<Entreprise>) EntrepriseHome.findall());
		
		 
	}

	public String InsertContrat() {   
		   
		contrat.setContratId(UUID.randomUUID().toString());
		System.out.println(etrp);
		contrat.setEntreprise(EntrepriseHome.findById(etrp));
		System.out.println(contratddebut);
		System.out.println(contratMontant);
		System.out.println(contratPenalite);
		
		
		EquipeHome equipeHome = new EquipeHome();
		
		contrat.setEquipe(equipeHome.findById("Equipe01"));
		contrat.setContratDatecrea(new Date());
		contrat.setContratEmpcrea("XF11");
		
		contrat.setContratddebut(contratddebut);
		contrat.setContratduree(30);
	    contrat.setContratMontant(contratMontant);
	    contrat.setContratPenalite(contratPenalite);
		
	    
	   contratHome.persist(contrat);
		
		
		    return null; 
	      
	   } 

	public List<Entreprise> getModel() {
		return model;
	}


	public void setModel(List<Entreprise> model) {
		this.model = model;
	}


	public String getEtrp() {
		return etrp;
	}


	public void setEtrp(String etrp) {
		this.etrp = etrp;
	}


	public ContratHome getContratHome() {
		return contratHome;
	}


	public void setContratHome(ContratHome contratHome) {
		this.contratHome = contratHome;
	}



	
	
	

}
