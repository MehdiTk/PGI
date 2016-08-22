package bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Contrat;
import model.ContratHome;
import model.Equipement;
import model.EquipementHome;
import model.Etatserveur;
import model.EtatserveurHome;
import model2.*;

@Named
@RequestScoped
public class EquipementBean {
	

	private List<Equipement> model;
	
	private EquipementHome equipementHome = new EquipementHome();
	static EtatserveurHome cpuUsageHome = new EtatserveurHome();
	
	
	@SuppressWarnings("unchecked")
	public EquipementBean() {
		// TODO Auto-generated constructor stub
		 
		 this.setModel((List<Equipement>) equipementHome.findEquipement("XF11"));
		
		 
	}


	public List<Equipement> getModel() {
		return model;
	}


	public void setModel(List<Equipement> model) {
		this.model = model;
	}
	
	
	@SuppressWarnings("unchecked")
	public String datalastone() throws InterruptedException {
		
		String DATE1 = ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getEtatId().toString();
		Thread.sleep(1000);
		String DATE2 = ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getEtatId().toString();
		
		if(DATE1.equals(DATE2))
			return "Deconnecté";
		
		return "Connecté";
	}
	
	
	

}
