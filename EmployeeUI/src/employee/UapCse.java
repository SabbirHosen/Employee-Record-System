/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.ArrayList;

/**
 *
 * @author Sabbir Hosen
 */
public class UapCse {
    ArrayList<Employee> employees = new ArrayList<>();
	String name;
	
	public UapCse(String name) {
		super();
		this.name = name;
	}
	
	private void addNewEmployee(Employee e)
	{
		employees.add(e);
	}
	
	public void addNewEmployees(String n, String i, String d, double s)
	{
//            System.out.println(n + i + d + s);
		Employee E = new SalariedEmployee(n,i,d,s);
		addNewEmployee(E);
               
	}
	
	public void addNewEmployees(String n, String i, String d, double hr,int hw)
	{
		Employee E = new HourlyEmployee(n,i,d,hr,hw);
		addNewEmployee(E);
	}
	
	public void addNewEmployees(String n, String i, String d, double p,double s)
	{
		Employee E = new CommissionEmployee(n,i,d,p,s);
		addNewEmployee(E);
	}
	
	public Employee findEmployee(String id)
	{
		for (int i = 0; i < employees.size(); i++) {
			
			Employee E = employees.get(i);
			if(E.getId().equals(id))
			{
				return E;
			}
		}
		return null;
	}
}
