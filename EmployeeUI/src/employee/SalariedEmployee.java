/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author Sabbir Hosen
 */
public class SalariedEmployee extends Employee{
    double monthlySalary;

	public SalariedEmployee(String name, String id, String designation, double monthlySalary) {
		super(name, id, designation);
		this.monthlySalary = monthlySalary;
	}
	void run(){
            System.out.println(getName());
        }
    @Override
	void increaseSalary(double amt) {
		 
		monthlySalary += amt;
	 }

    @Override
	double getSalary() {
		
		return monthlySalary;
	}
	
	@Override
	String display() {
		return super.display()+ " Salary: "+monthlySalary;
		
	}
}
