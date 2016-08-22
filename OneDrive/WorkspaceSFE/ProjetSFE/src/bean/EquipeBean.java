package bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Contrat;
import model.ContratHome;
import model.Etatserveur;
import model.EtatserveurHome;
import model2.*;

@Named
@RequestScoped
public class EquipeBean {
	

	private List<Contrat> model;
	
	private ContratHome contratHome = new ContratHome();
	
	
	@SuppressWarnings("unchecked")
	public EquipeBean() {
		// TODO Auto-generated constructor stub
		 
		 this.setModel((List<Contrat>) contratHome.findContrat("XF11"));
		
		 
	}


	public List<Contrat> getModel() {
		return model;
	}


	public void setModel(List<Contrat> model) {
		this.model = model;
	}
	
	
	

}
