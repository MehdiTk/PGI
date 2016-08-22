package bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Etatserveur;
import model.EtatserveurHome;
import model2.*;

@Named
@RequestScoped
public class ServerBean {
	

	private List<Etatserveur> model;
	private StringBuilder Cpu_data;
	private StringBuilder Cpu_date;
	static EtatserveurHome cpuUsageHome = new EtatserveurHome();
	
	public StringBuilder getCpu_data() {
		return Cpu_data;
	}

	public void setCpu_data(StringBuilder cpu_data) {
		Cpu_data = cpu_data;
	}

	@SuppressWarnings("unchecked")
	public ServerBean() {
		// TODO Auto-generated constructor stub
		 
		 this.setModel((List<Etatserveur>) cpuUsageHome.datachart());
		 Cpu_data = new StringBuilder();
		 Cpu_date = new StringBuilder();
		 //Cpu_data.append("65, 59, 80, 81, 56, 55");
		 System.out.println(model.size());
		 for (int i = 0 ; i < model.size() ; i++) {
			 Cpu_data.append(model.get(i).getEtatCpu());	
			 
			 if(i<model.size()-1)
				 Cpu_data.append(",");	
			 
			 Cpu_date.append(model.get(i).getEtatId()+"#");	
			 
		}
		 System.out.println(Cpu_data);
		 System.out.println(Cpu_date);
		 
		 
	}
	
	@SuppressWarnings("unchecked")
	public String datalastone() {
		
		return ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getEtatCpu().toString();
	}
	@SuppressWarnings("unchecked")
	public String dataram() {
		
		return ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getEtatMem().toString();
	}
	
	@SuppressWarnings("unchecked")
	public String datanetin() {
		
		return ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getIn().toString();
	}
public String datanetout() {
		
		return ((List<Etatserveur>) cpuUsageHome.datachart()).get(0).getOut().toString();
	}

	public List<Etatserveur> getModel() {
		return model;
	}

	public void setModel(List<Etatserveur> model) {
		this.model = model;
	}

	public StringBuilder getCpu_date() {
		return Cpu_date;
	}

	public void setCpu_date(StringBuilder cpu_date) {
		Cpu_date = cpu_date;
	}
	
	

}
