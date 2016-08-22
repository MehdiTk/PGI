package bean;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Employee;
import model.EmployeeHome;
import sun.util.logging.resources.logging;

import java.io.Serializable;
import java.util.logging.Logger;


@Named
@SessionScoped
public class LoginBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2476771279239926595L;
	Employee Emp;

	public LoginBean() {
		// TODO Auto-generated constructor stub
		Emp = new Employee();
		
		System.out.println("Login Bean : Init ......................");

	}
	
	  public Employee getEmp() {
		return Emp;
	}

	public void setEmp(Employee emp) {
		Emp = emp;
	}

	public String login() {   
		   

		   EmployeeHome Emp_Dao = new EmployeeHome();
	
		 
   
		    for(Employee e :Emp_Dao.GetAll())
		    {	
		    	System.out.println("Login Bean : Emp " + Emp_Dao.GetAll().size() +  " Found ......................");
		    	if(e.getEmpUsername().equals(Emp.getEmpUsername()))
		    			if(e.getEmpPassword().equals(Emp.getEmpPassword())) {
		    				System.out.println("Login Bean : User " +  Emp.getEmpUsername()  + " Found ......................");
		    				
		    				Emp = e;
		    				System.out.println("Login Bean : User " +  Emp.getEmpNom()  + " Found ......................");
		    				System.out.println("Login Bean : User " +  Emp.getEmpPrenom()  + " Found ......................");
		    				System.out.println("Login Bean : User " +  Emp.getEquipes().size()  + " Found ......................");
		    				return "main?faces-redirect=true";
		    			}
		    				
		    }
		    System.out.println("Login Bean : User " +  Emp.getEmpUsername()  + " Not Found ......................");
		    return null; 
	      
	   } 
	
	

}
