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
public class Communication {
    String searchId = "";
    double amt;
    static UapCse myUap = new UapCse("University of Asia Pacific");
    public void salaried(String name, String id, String des, double sal){
        myUap.addNewEmployees(name, id, des, sal);
        
    }
    public void commission(String name, String id, String des, double com, double comSale){
        myUap.addNewEmployees(name, id, des, com,comSale);
        
    }
    public void hourly(String name, String id, String des, double hlw, int hlr){
        myUap.addNewEmployees(name, id, des, hlw,hlr);
        
    }
    public ArrayList<Employee> show(){
        ArrayList<Employee> em = myUap.employees;
        return em;
    }
    public String searchId(){
       Employee E = myUap.findEmployee(searchId);
       if(E == null){
           return "Employee Not Found!";
       }else{
           String ob = E.display();
           return ob;
       }
    }
    public String salary(){
       Employee E = myUap.findEmployee(searchId);
       if(E == null){
           return "Employee Not Found!";
       }else{
           String name = E.getName();
           String id = E.getId();
           Double sal = E.getSalary();
           return "Name: "+name+" ID: "+id+" Salary: "+sal;
       }
    }
    
    public String updateSlary(){
       Employee E = myUap.findEmployee(searchId);
       if(E == null){
           return "N";
       }else{
           E.increaseSalary(amt);
           return "Y";
       }
       
    }
}
